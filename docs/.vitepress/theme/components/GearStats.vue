<script setup lang="ts">
import { computed, ref } from 'vue'
import { type Armor, armorPieces, itemName, stat, TIERS, type Weapon, type WeaponKind, weapons } from '../moregears'
import ItemSlot from './ItemSlot.vue'

type Row = (Weapon | Armor) & Record<string, unknown>

interface Column {
  key: string
  label: string
  short?: string
  /** Draws a bar scaled to the largest visible value. */
  bar?: boolean
  hint?: string
}

const props = withDefaults(defineProps<{ group: 'tools' | 'armor' | 'ranged'; tier?: string }>(), { tier: '' })

const KINDS: Record<string, WeaponKind[]> = {
  tools: ['sword', 'axe', 'pickaxe', 'shovel', 'hoe', 'spear', 'mace'],
  ranged: ['bow', 'arrow'],
}

const COLUMNS: Record<string, Column[]> = {
  tools: [
    { key: 'damage', label: 'Attack damage', short: 'Dmg', bar: true, hint: 'Including the 1 damage every player deals' },
    { key: 'speed', label: 'Attack speed', short: 'Spd', bar: true, hint: 'Attacks per second at full charge' },
    { key: 'durability', label: 'Durability', short: 'Dur', bar: true },
    { key: 'miningSpeed', label: 'Mining speed', short: 'Mine', hint: 'Block breaking speed on the right blocks (diamond is 8)' },
  ],
  armor: [
    { key: 'defense', label: 'Armor', short: 'Arm', bar: true },
    { key: 'toughness', label: 'Toughness', short: 'Tough', bar: true },
    {
      key: 'knockbackResistance',
      label: 'Knockback res.',
      short: 'KB',
      bar: true,
      hint: 'As shown in the tooltip; a full set adding up to 10 ignores knockback entirely',
    },
    { key: 'durability', label: 'Durability', short: 'Dur', bar: true },
  ],
  ranged: [
    {
      key: 'damage',
      label: 'Arrow damage',
      short: 'Dmg',
      bar: true,
      hint: 'Base damage before bow power and speed; a vanilla arrow is 2',
    },
    { key: 'durability', label: 'Bow durability', short: 'Dur', bar: true, hint: 'A vanilla bow has 384' },
  ],
}

const columns = computed(() => COLUMNS[props.group])
const all = computed<Row[]>(
  () =>
    (props.group === 'armor'
      ? armorPieces(props.tier || undefined)
      : weapons(KINDS[props.group], props.tier || undefined)) as Row[],
)

const tiers = computed(() => TIERS.filter((t) => all.value.some((row) => row.tier === t.id)))
const kinds = computed(() => {
  const list = all.value.map((row) => ('kind' in row ? row.kind : row.slot) as string)
  return [...new Set(list)]
})

const tierFilter = ref('')
const kindFilter = ref('')
const sortKey = ref('')
const sortDesc = ref(true)

const kindOf = (row: Row) => ('kind' in row ? row.kind : row.slot) as string

// Unbreakable items sort above everything, so null counts as infinite.
const sortValue = (row: Row, key: string) => {
  const value = row[key]
  if (value === null) return Infinity
  return typeof value === 'number' ? value : -Infinity
}

const rows = computed(() => {
  const filtered = all.value.filter(
    (row) => (!tierFilter.value || row.tier === tierFilter.value) && (!kindFilter.value || kindOf(row) === kindFilter.value),
  )
  if (!sortKey.value) return filtered
  const direction = sortDesc.value ? -1 : 1
  return [...filtered].sort((a, b) => direction * (sortValue(a, sortKey.value) - sortValue(b, sortKey.value)))
})

const maxima = computed(() =>
  Object.fromEntries(
    columns.value.map((column) => [
      column.key,
      Math.max(0, ...rows.value.map((row) => row[column.key]).filter((v): v is number => typeof v === 'number')),
    ]),
  ),
)

function barWidth(row: Row, key: string) {
  const value = row[key]
  if (value === null) return 100
  if (typeof value !== 'number' || !maxima.value[key]) return 0
  return (value / maxima.value[key]) * 100
}

/** Clicking a header cycles: highest first, lowest first, original order. */
function sortBy(key: string) {
  if (sortKey.value !== key) {
    sortKey.value = key
    sortDesc.value = true
  } else if (sortDesc.value) {
    sortDesc.value = false
  } else {
    sortKey.value = ''
    sortDesc.value = true
  }
}

const label = (kind: string) => kind.charAt(0).toUpperCase() + kind.slice(1)
</script>

<template>
  <div class="mg-stats">
    <div v-if="!tier || kinds.length > 1" class="filters">
      <div v-if="!tier" class="chips" role="group" aria-label="Tier">
        <button :class="{ active: !tierFilter }" @click="tierFilter = ''">All tiers</button>
        <button
          v-for="t in tiers"
          :key="t.id"
          :class="['tier', `tier-${t.id}`, { active: tierFilter === t.id }]"
          @click="tierFilter = tierFilter === t.id ? '' : t.id"
        >
          {{ t.name }}
        </button>
      </div>
      <div v-if="kinds.length > 1" class="chips" role="group" aria-label="Type">
        <button :class="{ active: !kindFilter }" @click="kindFilter = ''">All types</button>
        <button v-for="k in kinds" :key="k" :class="{ active: kindFilter === k }" @click="kindFilter = kindFilter === k ? '' : k">
          {{ label(k) }}
        </button>
      </div>
    </div>

    <div class="table-wrap">
      <table>
        <thead>
          <tr>
            <th>Item</th>
            <th v-for="column in columns" :key="column.key" :title="column.hint">
              <button class="sort" :class="{ sorted: sortKey === column.key }" @click="sortBy(column.key)">
                <span class="long">{{ column.label }}</span>
                <span class="short">{{ column.short ?? column.label }}</span>
                <span class="caret">{{ sortKey === column.key ? (sortDesc ? '▼' : '▲') : '⇅' }}</span>
              </button>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="row in rows" :key="row.id" :class="`tier-${row.tier}`">
            <td>
              <div class="item">
                <ItemSlot :id="row.id" />
                <span class="name">
                  <span>{{ itemName(row.id) }}</span>
                  <span class="badges">
                    <span v-if="row.unbreakable" class="badge unbreakable" title="Never loses durability">Unbreakable</span>
                    <span v-if="row.fireResistant" class="badge fire" title="Doesn't burn in fire or lava when dropped"
                      >Fireproof</span
                    >
                    <span v-if="row.chargeMultiplier" class="badge" title="Damage multiplier of the charged (held) attack">
                      Charge ×{{ row.chargeMultiplier }}
                    </span>
                  </span>
                </span>
              </div>
            </td>
            <td v-for="column in columns" :key="column.key" class="num">
              <span class="value">{{ stat(row[column.key] as number | null | undefined) }}</span>
              <span v-if="column.bar && row[column.key] !== undefined" class="bar">
                <span :class="{ infinite: row[column.key] === null }" :style="{ width: `${barWidth(row, column.key)}%` }" />
              </span>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<style scoped>
.mg-stats {
  margin: 16px 0;
}

.filters {
  display: flex;
  flex-direction: column;
  gap: 8px;
  margin-bottom: 12px;
}

.chips {
  display: flex;
  flex-wrap: wrap;
  gap: 6px;
}

.chips button {
  padding: 3px 12px;
  border: 1px solid var(--vp-c-divider);
  border-radius: 999px;
  font-size: 13px;
  font-weight: 500;
  color: var(--vp-c-text-2);
  transition:
    color 0.15s,
    border-color 0.15s,
    background 0.15s;
}

.chips button:hover {
  color: var(--vp-c-text-1);
  border-color: var(--vp-c-text-3);
}

.chips button.active {
  color: var(--vp-c-bg);
  background: var(--vp-c-brand-1);
  border-color: var(--vp-c-brand-1);
}

.chips button.tier {
  border-left: 4px solid var(--tier);
}

.chips button.tier.active {
  background: var(--tier);
  border-color: var(--tier);
  color: #fff;
}

.table-wrap {
  overflow-x: auto;
  border: 1px solid var(--vp-c-divider);
  border-radius: 10px;
}

table {
  display: table;
  width: 100%;
  margin: 0;
  border-collapse: collapse;
}

th,
td {
  padding: 8px 10px;
  border: none;
  border-bottom: 1px solid var(--vp-c-divider);
}

tr:last-child td {
  border-bottom: none;
}

thead th {
  padding: 8px 10px;
  background: var(--vp-c-bg-soft);
  vertical-align: bottom;
}

tbody tr {
  background: transparent !important;
  box-shadow: inset 4px 0 0 var(--tier);
}

tbody tr:hover {
  background: var(--vp-c-bg-soft) !important;
}

.sort {
  display: inline-flex;
  align-items: center;
  text-align: left;
  line-height: 1.3;
  gap: 4px;
  font: inherit;
  font-weight: 600;
}

.caret {
  font-size: 10px;
  color: var(--vp-c-text-3);
}

.sorted .caret {
  color: var(--vp-c-brand-1);
}

.short {
  display: none;
}

.item {
  display: flex;
  align-items: center;
  gap: 10px;
  min-width: 180px;
}

.name {
  display: flex;
  font-size: 14px;
  flex-direction: column;
  line-height: 1.3;
  font-weight: 500;
}

.badges {
  display: flex;
  flex-wrap: wrap;
  gap: 4px;
  margin-top: 2px;
}

.badge {
  padding: 0 6px;
  border-radius: 4px;
  font-size: 11px;
  font-weight: 600;
  line-height: 18px;
  color: var(--vp-c-text-2);
  background: var(--vp-c-default-soft);
}

.badge.unbreakable {
  color: var(--vp-c-purple-1);
  background: var(--vp-c-purple-soft);
}

.badge.fire {
  color: var(--vp-c-warning-1);
  background: var(--vp-c-warning-soft);
}

.num {
  min-width: 64px;
  font-variant-numeric: tabular-nums;
}

.value {
  display: block;
  font-weight: 600;
}

.bar {
  display: block;
  height: 5px;
  margin-top: 4px;
  border-radius: 3px;
  background: var(--vp-c-default-soft);
  overflow: hidden;
}

.bar span {
  display: block;
  height: 100%;
  border-radius: 3px;
  background: var(--tier);
}

.bar span.infinite {
  background: repeating-linear-gradient(-45deg, var(--tier) 0 6px, color-mix(in srgb, var(--tier) 55%, transparent) 6px 12px);
}

@media (max-width: 640px) {
  .long {
    display: none;
  }

  .short {
    display: inline;
  }

  .num {
    min-width: 56px;
  }
}
</style>
