// Pulls wiki data straight from the mod so the docs never drift from the game:
// datagen output (recipes, ore generation, loot tables, lang) and gear stats read from the Java sources.
// Run `./gradlew :neoforge:runData` first when the mod's data changes.
import { existsSync, mkdirSync, readdirSync, readFileSync, writeFileSync } from 'node:fs'
import { basename, dirname, join } from 'node:path'
import { fileURLToPath } from 'node:url'

const docs = join(dirname(fileURLToPath(import.meta.url)), '..')
const root = join(docs, '..')
const generated = join(root, 'common/src/generated/resources')
const assets = join(root, 'common/src/main/resources/assets/moregears')
const javaRoot = join(root, 'common/src/main/java/com/coolerpromc/moregears')
const data = join(generated, 'data')

if (!existsSync(generated)) {
  console.error(`No datagen output at ${generated}. Run ./gradlew :neoforge:runData first.`)
  process.exit(1)
}

const readJson = (file) => JSON.parse(readFileSync(file, 'utf8'))
const jsonFiles = (dir) =>
  existsSync(dir)
    ? readdirSync(dir)
        .filter((f) => f.endsWith('.json'))
        .sort()
    : []
const java = (path) => readFileSync(join(javaRoot, path), 'utf8')
const round = (value) => Math.round(value * 100) / 100

function fail(message) {
  console.error(`sync-data: ${message}`)
  process.exit(1)
}

const lang = readJson(join(assets, 'lang/en_us.json'))

// Item names for mod items; vanilla names are prettified on the page.
const names = {}
for (const [key, value] of Object.entries(lang)) {
  const match = key.match(/^(item|block)\.moregears\.([a-z0-9_]+)$/)
  if (match) names[`moregears:${match[2]}`] = value
}

// Mod textures are hosted at 1024x1024 alongside the vanilla renders; upload new ones there before syncing.
// Block items have no flat texture, so their icons are rendered from the block model (sources kept in public/icons/).
// The lang file still names removed items (the old copper gear), so only items with a texture count.
const HOSTED_TEXTURES = 'https://storage.googleapis.com/coolerpromc/textures/moregears'
const pngNames = (dir) =>
  existsSync(dir)
    ? readdirSync(dir)
        .filter((f) => f.endsWith('.png'))
        .map((f) => basename(f, '.png'))
    : []
const itemTextures = new Set(pngNames(join(assets, 'textures/item')))
const textures = {}
for (const id of Object.keys(names)) {
  const name = id.split(':')[1]
  if (itemTextures.has(name)) textures[id] = `${HOSTED_TEXTURES}/${name}.png`
}
for (const name of pngNames(join(docs, 'public/icons'))) {
  textures[`moregears:${name}`] = `${HOSTED_TEXTURES}/${name}.png`
}

// ---------- Recipes ----------

const ingredient = (value) => {
  if (typeof value === 'string') return value
  if (Array.isArray(value)) return ingredient(value[0])
  if (value?.item) return value.item
  if (value?.tag) return `#${value.tag}`
  return '?'
}

function readRecipe(id, json) {
  const recipe = { id, type: json.type }
  switch (json.type) {
    case 'minecraft:crafting_shaped':
      recipe.pattern = json.pattern
      recipe.key = Object.fromEntries(Object.entries(json.key).map(([symbol, value]) => [symbol, ingredient(value)]))
      break
    case 'minecraft:crafting_shapeless':
      recipe.ingredients = json.ingredients.map(ingredient)
      break
    case 'minecraft:smithing_transform':
      recipe.template = ingredient(json.template)
      recipe.base = ingredient(json.base)
      recipe.addition = ingredient(json.addition)
      break
    case 'moregears:alloy_smelting':
      recipe.inputs = json.ingredients.map((entry) => ({ id: ingredient(entry.ingredient), count: entry.count ?? 1 }))
      recipe.outputs = json.output.map((entry) => ({ id: entry.id, count: entry.count ?? 1 }))
      recipe.result = recipe.outputs[0]
      return recipe
    default:
      recipe.ingredient = ingredient(json.ingredient)
      recipe.cookingTime = json.cookingtime
      recipe.experience = json.experience
  }
  recipe.result = { id: json.result?.id, count: json.result?.count ?? 1 }
  return recipe
}

// The mod writes its smelting and smithing recipes under the minecraft namespace.
const recipes = []
for (const namespace of ['moregears', 'minecraft']) {
  const dir = join(data, namespace, 'recipe')
  for (const sub of ['', 'alloy_smelting']) {
    for (const file of jsonFiles(join(dir, sub))) {
      const path = sub ? `${sub}/${basename(file, '.json')}` : basename(file, '.json')
      recipes.push(readRecipe(`${namespace}:${path}`, readJson(join(dir, sub, file))))
    }
  }
}

// ---------- Ore generation ----------

const DIMENSIONS = { '#minecraft:is_overworld': 'overworld', '#minecraft:is_nether': 'nether', '#minecraft:is_end': 'end' }
const worldgen = join(data, 'moregears/worldgen')
const modifiers = Object.fromEntries(
  jsonFiles(join(data, 'moregears/neoforge/biome_modifier')).map((file) => {
    const json = readJson(join(data, 'moregears/neoforge/biome_modifier', file))
    return [json.features, DIMENSIONS[json.biomes] ?? json.biomes]
  }),
)

const lootDrop = (block) => {
  const file = join(data, 'moregears/loot_table/blocks', `${block.split(':')[1]}.json`)
  if (!existsSync(file)) return block
  const entries = readJson(file).pools.flatMap((pool) => pool.entries.flatMap((entry) => entry.children ?? [entry]))
  const drop =
    entries.find((entry) => entry.condition !== 'minecraft:tool/can_silk_touch' && !entry.conditions?.length) ?? entries[0]
  return drop?.name ?? block
}

const ores = jsonFiles(join(worldgen, 'placed_feature')).map((file) => {
  const placed = readJson(join(worldgen, 'placed_feature', file))
  const feature = readJson(join(worldgen, 'feature', `${placed.feature.split(':')[1]}.json`))
  const placement = (type) => placed.placement.find((p) => p.type === type)
  const height = placement('minecraft:height_range')?.height
  const blocks = feature.config?.targets ?? feature.targets
  return {
    id: placed.feature,
    dimension: modifiers[`moregears:${basename(file, '.json')}`] ?? 'unknown',
    blocks: blocks.map((target) => target.state.Name ?? target.state),
    drop: lootDrop(blocks[0].state.Name ?? blocks[0].state),
    veinsPerChunk: placement('minecraft:count')?.count ?? 1,
    veinSize: (feature.config ?? feature).size,
    distribution: (height?.type ?? 'minecraft:uniform').split(':')[1],
    minY: height?.min_inclusive?.absolute ?? null,
    maxY: height?.max_inclusive?.absolute ?? null,
  }
})

// ---------- Gear stats (parsed from the Java sources) ----------
// Formulas follow vanilla: players have 1 base attack damage and 4 base attack speed.

const javaNumber = (text) => (text === 'Integer.MAX_VALUE' ? null : parseFloat(text))

const toolMaterials = {}
for (const match of java('tool/MGToolMaterials.java').matchAll(
  /(\w+)\s*=\s*new ToolMaterial\([^,]+,\s*([\w.]+),\s*([\d.]+)[fF]?,\s*([\d.]+)[fF]?,\s*(\d+)/g,
)) {
  toolMaterials[match[1]] = {
    durability: javaNumber(match[2]),
    miningSpeed: parseFloat(match[3]),
    damageBonus: parseFloat(match[4]),
    enchantability: parseInt(match[5]),
  }
}

const armorMaterials = {}
for (const chunk of java('armor/MGArmorMaterials.java').split('public static final ArmorMaterial').slice(1)) {
  const name = chunk.match(/register\("(\w+)"/)?.[1]
  const tail = chunk.match(/\}\),\s*(\d+),\s*[\w.]+,\s*[\w.]+,\s*([\d.]+)[fF]?,\s*([\d.]+)[fF]?/)
  if (!name || !tail) fail(`could not parse armor material:\n${chunk.slice(0, 200)}`)
  armorMaterials[name] = {
    defense: Object.fromEntries(
      [...chunk.matchAll(/ArmorType\.(\w+),\s*(\d+)/g)].map((m) => [m[1].toLowerCase(), parseInt(m[2])]),
    ),
    enchantability: parseInt(tail[1]),
    toughness: parseFloat(tail[2]),
    knockbackResistance: parseFloat(tail[3]),
  }
}

// Durability multiplier per armor piece, from net.minecraft.world.item.equipment.ArmorType.
const ARMOR_UNIT_DURABILITY = { helmet: 11, chestplate: 16, leggings: 15, boots: 13 }

const weapons = []
const armor = []
for (const chunk of java('item/MGItems.java').split('public static final').slice(1)) {
  const id = chunk.match(/register(?:Item)?\("(\w+)"/)?.[1]
  if (!id) continue
  const tier = id.split('_')[0]
  const base = {
    id: `moregears:${id}`,
    tier,
    fireResistant: /fireResistant\(\)/.test(chunk),
    unbreakable: /UNBREAKABLE/.test(chunk),
  }

  const tool = chunk.match(
    /(?:\.(sword|pickaxe|shovel|axe|hoe)|new \w*?(Sword|Pickaxe|Shovel|Axe|Hoe))\(\s*MGToolMaterials\.(\w+),\s*([-\d.]+)[fF]?,\s*([-\d.]+)[fF]?/,
  )
  const spear = chunk.match(/\.spear\(\s*MGToolMaterials\.(\w+),\s*([\d.]+)[fF]?,\s*([\d.]+)[fF]?/)
  const mace = chunk.match(/createAttributes\(\s*MGToolMaterials\.(\w+),\s*([-\d.]+)[fF]?\)/)
  const bow = /new BowItem/.test(chunk) ? chunk.match(/durability\(([\w.]+)\)/) : null
  const arrow = chunk.match(/new MGArrowItem\(\s*properties,\s*([\d.]+)[dD]?/)
  const armorPiece = chunk.match(/new (\w+)Armor\(\s*ArmorType\.(\w+)/)
  // Shields and crossbows take their durability from the shared property helpers.
  const shield = chunk.match(/new MGShieldItem\(\s*shieldProperties\(properties,\s*([\w.]+)\)/)
  const crossbow = chunk.match(/new CrossbowItem\(\s*crossbowProperties\(properties,\s*([\w.]+)\)/)
  const trident = /new MGTridentItem\(/.test(chunk)
    ? chunk.match(/BASE_ATTACK_DAMAGE_ID,\s*([\d.]+),[\s\S]*?BASE_ATTACK_SPEED_ID,\s*([-\d.]+)/)
    : null
  const elytra = /DataComponents\.GLIDER/.test(chunk)

  if (tool) {
    const material = toolMaterials[tool[3]]
    weapons.push({
      ...base,
      kind: (tool[1] ?? tool[2]).toLowerCase(),
      durability: base.unbreakable ? null : material.durability,
      damage: round(1 + material.damageBonus + parseFloat(tool[4])),
      speed: round(4 + parseFloat(tool[5])),
      miningSpeed: material.miningSpeed,
      enchantability: material.enchantability,
    })
  } else if (spear) {
    const material = toolMaterials[spear[1]]
    weapons.push({
      ...base,
      kind: 'spear',
      durability: base.unbreakable ? null : material.durability,
      damage: round(1 + material.damageBonus),
      speed: round(1 / parseFloat(spear[2])),
      chargeMultiplier: parseFloat(spear[3]),
      enchantability: material.enchantability,
    })
  } else if (mace) {
    const material = toolMaterials[mace[1]]
    weapons.push({
      ...base,
      kind: 'mace',
      durability: base.unbreakable ? null : material.durability,
      damage: round(1 + material.damageBonus * 2),
      speed: round(4 + parseFloat(mace[2])),
      enchantability: material.enchantability,
    })
  } else if (trident) {
    const material = toolMaterials.ENDERITE_TIER
    weapons.push({
      ...base,
      kind: 'trident',
      durability: base.unbreakable ? null : material.durability,
      damage: round(1 + parseFloat(trident[1])),
      speed: round(4 + parseFloat(trident[2])),
      enchantability: material.enchantability,
    })
  } else if (shield) {
    weapons.push({ ...base, kind: 'shield', durability: base.unbreakable ? null : javaNumber(shield[1]) })
  } else if (crossbow) {
    weapons.push({ ...base, kind: 'crossbow', durability: base.unbreakable ? null : javaNumber(crossbow[1]) })
  } else if (bow) {
    weapons.push({ ...base, kind: 'bow', durability: base.unbreakable ? null : javaNumber(bow[1]) })
  } else if (arrow) {
    weapons.push({ ...base, kind: 'arrow', damage: parseFloat(arrow[1]) })
  } else if (elytra) {
    weapons.push({ ...base, kind: 'elytra', durability: base.unbreakable ? null : javaNumber(chunk.match(/durability\(([\w.]+)\)/)?.[1] ?? '0') })
  } else if (armorPiece) {
    const source = java(`armor/custom/${armorPiece[1]}Armor.java`)
    const material = armorMaterials[tier]
    const slot = armorPiece[2].toLowerCase()
    const multiplier = source.match(/getDurability\((\d+)\)/)?.[1]
    if (!material) fail(`no armor material for ${id}`)
    armor.push({
      ...base,
      fireResistant: /fireResistant\(\)/.test(source),
      unbreakable: /UNBREAKABLE/.test(source),
      slot,
      durability: multiplier ? ARMOR_UNIT_DURABILITY[slot] * parseInt(multiplier) : null,
      defense: material.defense[slot],
      toughness: material.toughness,
      // Shown the way the in-game tooltip shows it (0.1 = +1).
      knockbackResistance: round(material.knockbackResistance * 10),
      enchantability: material.enchantability,
    })
  }
}

if (!weapons.some((w) => w.kind === 'sword') || !armor.length) fail('parsed no swords or armor; did MGItems.java change shape?')
for (const item of [...weapons, ...armor]) {
  if (!textures[item.id]) fail(`${item.id} has stats but no texture`)
}

mkdirSync(join(docs, '.vitepress/data'), { recursive: true })
writeFileSync(
  join(docs, '.vitepress/data/data.json'),
  JSON.stringify({ names, textures, recipes, ores, weapons, armor }, null, 2),
)
console.log(
  `Synced ${recipes.length} recipes, ${ores.length} ores, ${weapons.length} weapons/tools, ${armor.length} armor pieces, ${Object.keys(textures).length} textures.`,
)
