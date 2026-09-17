<script setup lang="ts">
import { computed } from 'vue'
import { data, DIMENSION_NAMES, itemIcon, itemName } from '../moregears'
import ItemSlot from './ItemSlot.vue'

/** `id` is the ore's feature, e.g. `tin_ore`. `tool` names the weakest pickaxe that gets a drop. */
const props = defineProps<{ id: string; tool?: string; toolIcon?: string }>()

const ore = computed(() => data.ores.find((o) => o.id === props.id || o.id === `moregears:${props.id}`))

// Build limits per dimension; ore placement outside them simply never happens.
const WORLD: Record<string, [number, number]> = { overworld: [-64, 320], nether: [0, 256], end: [0, 256] }
const world = computed(() => WORLD[ore.value?.dimension ?? 'overworld'] ?? [-64, 320])

const range = computed(() => {
  const o = ore.value!
  const [bottom, top] = world.value
  return { min: Math.max(o.minY ?? bottom, bottom), max: Math.min(o.maxY ?? top, top) }
})

/** Trapezoid placement with no plateau peaks halfway between its bounds (before clamping to the world). */
const peak = computed(() => {
  const o = ore.value!
  return o.distribution === 'trapezoid' && o.minY !== null && o.maxY !== null ? Math.round((o.minY + o.maxY) / 2) : null
})

// Chart: world height mapped onto a 200px column, the density shape drawn to the right of the axis.
const H = 200
const W = 120
const y = (level: number) => {
  const [bottom, top] = world.value
  return H - ((level - bottom) / (top - bottom)) * H
}
const shape = computed(() => {
  const o = ore.value!
  const x0 = 34
  const width = W - x0 - 4
  if (peak.value === null) {
    return `M${x0},${y(range.value.max)} h${width} V${y(range.value.min)} H${x0} Z`
  }
  // Density grows linearly from each bound to the peak; the part below the world floor is cut off.
  const clampY = (level: number) => y(Math.max(level, world.value[0]))
  const at = (level: number) => {
    const half = (o.maxY! - o.minY!) / 2
    return x0 + width * Math.max(0, 1 - Math.abs(level - peak.value!) / half)
  }
  const points = [
    [x0, clampY(o.minY!)],
    [at(Math.max(o.minY!, world.value[0])), clampY(o.minY!)],
    [at(peak.value), y(peak.value)],
    [x0, y(o.maxY!)],
  ]
  return `M${points.map(([px, py]) => `${px.toFixed(1)},${py.toFixed(1)}`).join(' L')} Z`
})

const ticks = computed(() => {
  const [bottom, top] = world.value
  return [bottom, 0, 64, top].filter((v, i, list) => list.indexOf(v) === i && v >= bottom && v <= top)
})

const REPLACES: Record<string, string> = {
  overworld: 'Stone and deepslate',
  nether: 'Netherrack, basalt and blackstone',
  end: 'End stone',
}
</script>

<template>
  <div v-if="ore" class="mg-ore" :class="`dim-${ore.dimension}`">
    <div class="info">
      <div class="blocks">
        <img
          v-for="block in ore.blocks"
          :key="block"
          :src="itemIcon(block) ?? ''"
          :alt="itemName(block)"
          :title="itemName(block)"
        />
      </div>
      <div class="title">
        <strong>{{ itemName(ore.blocks[0]) }}</strong>
        <span class="dimension">{{ DIMENSION_NAMES[ore.dimension] ?? ore.dimension }}</span>
      </div>
      <dl>
        <dt>Height</dt>
        <dd>
          Y {{ range.min }} to {{ range.max }}
          <span v-if="peak !== null" class="mg-muted">(most common at Y {{ peak }})</span>
        </dd>
        <dt>Veins</dt>
        <dd>{{ ore.veinsPerChunk }} per chunk, up to {{ ore.veinSize }} blocks each</dd>
        <dt>Replaces</dt>
        <dd>{{ REPLACES[ore.dimension] ?? '–' }}</dd>
        <template v-if="tool">
          <dt>Mine with</dt>
          <dd class="with-slot"><ItemSlot v-if="toolIcon" :id="toolIcon" size="sm" /> {{ tool }}</dd>
        </template>
        <dt>Drops</dt>
        <dd class="with-slot">
          <ItemSlot :id="ore.drop" size="sm" /> {{ itemName(ore.drop) }} <span class="mg-muted">(Fortune applies)</span>
        </dd>
      </dl>
    </div>
    <svg class="chart" :viewBox="`0 -8 ${W} ${H + 16}`" role="img" :aria-label="`Generates from Y ${range.min} to ${range.max}`">
      <rect x="34" :y="0" :width="W - 38" :height="H" class="world" rx="3" />
      <path :d="shape" class="density" />
      <g v-for="tick in ticks" :key="tick">
        <line x1="30" :x2="W - 4" :y1="y(tick)" :y2="y(tick)" class="grid" />
        <text x="26" :y="y(tick) + 3.5" text-anchor="end" class="label">{{ tick }}</text>
      </g>
    </svg>
  </div>
  <p v-else class="mg-muted">Ore {{ id }} not found.</p>
</template>

<style scoped>
.mg-ore {
  --dim: #5b8c3a;
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 16px 28px;
  margin: 16px 0;
  padding: 16px 20px;
  border: 1px solid var(--vp-c-divider);
  border-left: 4px solid var(--dim);
  border-radius: 10px;
  background: linear-gradient(90deg, color-mix(in srgb, var(--dim) 10%, transparent), transparent 55%);
}

.dim-nether {
  --dim: #b0342c;
}

.dim-end {
  --dim: #9d8fd6;
}

.info {
  flex: 1 1 300px;
}

.blocks {
  display: flex;
  gap: 8px;
}

.blocks img {
  width: 64px;
  height: 64px;
  image-rendering: pixelated;
  filter: drop-shadow(0 4px 6px rgba(0, 0, 0, 0.25));
}

.title {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 8px;
  margin: 8px 0 4px;
  font-size: 18px;
}

.dimension {
  padding: 1px 8px;
  border-radius: 999px;
  font-size: 12px;
  font-weight: 600;
  color: #fff;
  background: var(--dim);
}

dl {
  display: grid;
  grid-template-columns: auto 1fr;
  gap: 4px 14px;
  margin: 8px 0 0;
  font-size: 14px;
}

dt {
  font-weight: 600;
  color: var(--vp-c-text-2);
}

dd {
  margin: 0;
}

.with-slot {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 6px;
}

.chart {
  flex: none;
  width: 130px;
  height: 230px;
}

.world {
  fill: var(--vp-c-bg-soft);
  stroke: var(--vp-c-divider);
}

.density {
  fill: color-mix(in srgb, var(--dim) 70%, transparent);
  stroke: var(--dim);
  stroke-width: 1.5;
}

.grid {
  stroke: var(--vp-c-text-3);
  stroke-dasharray: 2 3;
  stroke-width: 0.6;
}

.label {
  font: 10px var(--vp-font-family-mono);
  fill: var(--vp-c-text-2);
}
</style>
