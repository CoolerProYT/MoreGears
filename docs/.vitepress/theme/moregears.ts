// @ts-ignore
import raw from '../data/data.json'

export interface Stack {
  id: string
  count: number
}

export interface Recipe {
  id: string
  type: string
  result: Stack
  pattern?: string[]
  key?: Record<string, string>
  ingredients?: string[]
  ingredient?: string
  cookingTime?: number
  experience?: number
  template?: string
  base?: string
  addition?: string
  inputs?: Stack[]
  outputs?: Stack[]
}

export interface Ore {
  id: string
  dimension: 'overworld' | 'nether' | 'end' | string
  blocks: string[]
  drop: string
  veinsPerChunk: number
  veinSize: number
  distribution: 'trapezoid' | 'uniform' | string
  minY: number | null
  maxY: number | null
}

export type WeaponKind = 'sword' | 'pickaxe' | 'shovel' | 'axe' | 'hoe' | 'spear' | 'mace' | 'bow' | 'arrow'
export type ArmorSlot = 'helmet' | 'chestplate' | 'leggings' | 'boots'

interface Gear {
  id: string
  tier: Tier
  fireResistant: boolean
  unbreakable: boolean
  /** Null when the item never breaks. */
  durability?: number | null
  enchantability?: number
}

export interface Weapon extends Gear {
  kind: WeaponKind
  damage?: number
  speed?: number
  miningSpeed?: number
  chargeMultiplier?: number
}

export interface Armor extends Gear {
  slot: ArmorSlot
  defense: number
  toughness: number
  knockbackResistance: number
}

export const data = raw as unknown as {
  names: Record<string, string>
  textures: Record<string, string>
  recipes: Recipe[]
  ores: Ore[]
  weapons: Weapon[]
  armor: Armor[]
}

export type Tier = 'copper' | 'bronze' | 'steel' | 'ruby' | 'titanium' | 'enderite'

/** Progression order. Netherite sits between ruby and titanium, which upgrades from it. */
export const TIERS: { id: Tier; name: string; material: string }[] = [
  { id: 'copper', name: 'Copper', material: 'minecraft:copper_ingot' },
  { id: 'bronze', name: 'Bronze', material: 'moregears:bronze_ingot' },
  { id: 'steel', name: 'Steel', material: 'moregears:steel_ingot' },
  { id: 'ruby', name: 'Ruby', material: 'moregears:ruby' },
  { id: 'titanium', name: 'Titanium', material: 'moregears:titanium_ingot' },
  { id: 'enderite', name: 'Enderite', material: 'moregears:enderite_ingot' },
]

export const tierName = (tier: string) => TIERS.find((t) => t.id === tier)?.name ?? tier

export const WEAPON_ORDER: WeaponKind[] = ['sword', 'axe', 'pickaxe', 'shovel', 'hoe', 'spear', 'mace', 'bow', 'arrow']
export const ARMOR_ORDER: ArmorSlot[] = ['helmet', 'chestplate', 'leggings', 'boots']

const byTier = (a: Gear, b: Gear) => TIERS.findIndex((t) => t.id === a.tier) - TIERS.findIndex((t) => t.id === b.tier)

export function weapons(kinds: WeaponKind[] = WEAPON_ORDER, tier?: string): Weapon[] {
  return data.weapons
    .filter((w) => kinds.includes(w.kind) && (!tier || w.tier === tier))
    .sort((a, b) => byTier(a, b) || WEAPON_ORDER.indexOf(a.kind) - WEAPON_ORDER.indexOf(b.kind))
}

export function armorPieces(tier?: string): Armor[] {
  return data.armor
    .filter((a) => !tier || a.tier === tier)
    .sort((a, b) => byTier(a, b) || ARMOR_ORDER.indexOf(a.slot) - ARMOR_ORDER.indexOf(b.slot))
}

/** Every mod item of a tier, gear first, in display order. */
export function tierItems(tier: string): string[] {
  return [...weapons(WEAPON_ORDER, tier), ...armorPieces(tier)].map((g) => g.id)
}

/** Mod items use their in-game name; vanilla ids are turned into readable names. */
export function itemName(id: string): string {
  if (data.names[id]) return data.names[id]
  const path = id.replace(/^#/, '').split(':').pop() ?? id
  return path
    .split('_')
    .map((word) => (['of', 'the', 'and'].includes(word) ? word : word.charAt(0).toUpperCase() + word.slice(1)))
    .join(' ')
}

export const isModItem = (id: string) => id.startsWith('moregears:')

/** Hosted renders of vanilla items, one PNG per item id. Mojang's textures are not bundled here. */
const VANILLA_ICONS = 'https://storage.googleapis.com/coolerpromc/textures'

/** Where to load an item's icon from: the hosted mod textures listed by the sync script, or the vanilla renders. */
export function itemIcon(id: string): string | null {
  if (data.textures[id]) return data.textures[id]
  const [namespace, path] = id.includes(':') ? id.split(':') : ['minecraft', id]
  if (namespace !== 'minecraft') return null
  return `${VANILLA_ICONS}/${namespace}/${path}.png`
}

/** Finds a recipe by full id, or by path in either namespace the mod writes to. */
export function recipe(id: string): Recipe | undefined {
  return data.recipes.find((r) => r.id === id || r.id === `moregears:${id}` || r.id === `minecraft:${id}`)
}

export function recipesFor(result: string, types?: string[]): Recipe[] {
  return data.recipes.filter((r) => r.result.id === result && (!types || types.includes(r.type)))
}

export const COOKING_TYPES = ['minecraft:smelting', 'minecraft:blasting', 'minecraft:smoking', 'minecraft:campfire_cooking']

export function seconds(ticks: number): string {
  const value = ticks / 20
  return Number.isInteger(value) ? `${value}` : value.toFixed(1)
}

export function stat(value: number | null | undefined): string {
  if (value === undefined) return '–'
  if (value === null) return '∞'
  return Number.isInteger(value) ? value.toLocaleString('en-US') : `${value}`
}

export const DIMENSION_NAMES: Record<string, string> = {
  overworld: 'Overworld',
  nether: 'The Nether',
  end: 'The End',
}
