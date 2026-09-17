<script setup lang="ts">
import { computed } from 'vue'
import { withBase } from 'vitepress'
import { COOKING_TYPES, type Recipe, recipe as findRecipe, recipesFor, seconds } from '../moregears'
import ItemSlot from './ItemSlot.vue'

/**
 * Pass `id` for one recipe. Pass `result` to show every cooking recipe for an item in one card,
 * with the inputs cycling and each station listed.
 */
const props = defineProps<{ id?: string; result?: string }>()

const cooking = computed(() => (props.result ? recipesFor(props.result, COOKING_TYPES) : []))
const recipe = computed<Recipe | undefined>(() => (props.id ? findRecipe(props.id) : cooking.value[0]))

const STATIONS: Record<string, { name: string; icon: string }> = {
  'minecraft:crafting_shaped': { name: 'Crafting Table', icon: 'minecraft:crafting_table' },
  'minecraft:crafting_shapeless': { name: 'Crafting Table', icon: 'minecraft:crafting_table' },
  'minecraft:smithing_transform': { name: 'Smithing Table', icon: 'minecraft:smithing_table' },
  'minecraft:smelting': { name: 'Furnace', icon: 'minecraft:furnace' },
  'minecraft:blasting': { name: 'Blast Furnace', icon: 'minecraft:blast_furnace' },
  'minecraft:smoking': { name: 'Smoker', icon: 'minecraft:smoker' },
  'minecraft:campfire_cooking': { name: 'Campfire', icon: 'minecraft:campfire' },
  'moregears:alloy_smelting': { name: 'Alloy Smelter', icon: 'moregears:alloy_smelter' },
}

const kind = computed(() => {
  const type = recipe.value?.type ?? ''
  if (type.startsWith('minecraft:crafting')) return 'crafting'
  if (type === 'minecraft:smithing_transform') return 'smithing'
  if (type === 'moregears:alloy_smelting') return 'alloy'
  return 'cooking'
})

/** Stations shown in the header. A cooking card lists each station that has a recipe, fastest last. */
const stations = computed(() => {
  if (kind.value !== 'cooking' || !cooking.value.length) return recipe.value ? [STATIONS[recipe.value.type]] : []
  return COOKING_TYPES.filter((type) => cooking.value.some((r) => r.type === type)).map((type) => STATIONS[type])
})

const cookingInputs = computed(() => {
  const list = cooking.value.length ? cooking.value : recipe.value ? [recipe.value] : []
  return [...new Set(list.map((r) => r.ingredient!))]
})

const cookTimes = computed(() => {
  const list = cooking.value.length ? cooking.value : recipe.value ? [recipe.value] : []
  return COOKING_TYPES.flatMap((type) => {
    const r = list.find((x) => x.type === type)
    return r?.cookingTime ? [`${STATIONS[type].name}: ${seconds(r.cookingTime)} s`] : []
  })
})

/** Nine cells for the crafting grid, left to right, top to bottom. One-column patterns (swords, arrows) sit in the middle column. */
const grid = computed<(string | null)[]>(() => {
  const r = recipe.value
  if (!r) return []
  if (r.pattern && r.key) {
    const width = Math.max(...r.pattern.map((row) => row.length))
    const offset = width === 1 ? 1 : 0
    const cells: (string | null)[] = []
    for (let row = 0; row < 3; row++) {
      for (let col = 0; col < 3; col++) {
        const symbol = r.pattern[row]?.[col - offset] ?? ' '
        cells.push(symbol === ' ' ? null : (r.key[symbol] ?? null))
      }
    }
    return cells
  }
  return Array.from({ length: 9 }, (_, i) => r.ingredients?.[i] ?? null)
})
</script>

<template>
  <div v-if="recipe" class="mg-recipe">
    <div class="header">
      <span v-for="station in stations" :key="station.name" class="station">
        <ItemSlot :id="station.icon" size="sm" />
        {{ station.name }}
      </span>
      <span v-if="kind === 'crafting'" class="shape">{{ recipe.pattern ? 'Shaped' : 'Shapeless' }}</span>
    </div>

    <div class="body">
      <div v-if="kind === 'crafting'" class="grid">
        <ItemSlot v-for="(cell, i) in grid" :id="cell" :key="i" />
      </div>

      <div v-else-if="kind === 'smithing'" class="row">
        <ItemSlot :id="recipe.template" />
        <ItemSlot :id="recipe.base" />
        <ItemSlot :id="recipe.addition" />
      </div>

      <div v-else-if="kind === 'alloy'" class="furnace">
        <div class="row">
          <ItemSlot v-for="input in recipe.inputs" :id="input.id" :key="input.id" :count="input.count" />
        </div>
        <img class="flame" :src="withBase('/furnace_fire.png')" alt="" />
        <span class="energy" title="Burns fuel into energy, 10 FE per tick while smelting">⚡ Fuel or FE</span>
      </div>

      <div v-else class="furnace">
        <ItemSlot :ids="cookingInputs" />
        <img class="flame" :src="withBase('/furnace_fire.png')" alt="" />
        <ItemSlot id="minecraft:coal" />
      </div>

      <svg class="arrow" viewBox="0 0 22 15" aria-hidden="true">
        <path d="M0 5h13V0h2v2h2v2h2v2h2v3h-2v2h-2v2h-2v2h-2v-5H0z" />
      </svg>

      <span class="output">
        <ItemSlot :id="recipe.result.id" :count="recipe.result.count" size="lg" />
      </span>
    </div>

    <div v-if="kind === 'cooking' && cookTimes.length" class="footer">{{ cookTimes.join(' · ') }}</div>
    <div v-else-if="kind === 'alloy'" class="footer">5 s · uses 1,000 FE</div>
  </div>
  <p v-else class="mg-muted">Recipe {{ id ?? result }} not found.</p>
</template>

<style scoped>
.mg-recipe {
  display: inline-flex;
  flex-direction: column;
  min-width: 260px;
  margin: 8px 0;
  padding: 10px 14px 12px;
  background: var(--mg-gui-bg);
  border: 3px solid;
  border-color: var(--mg-gui-light) var(--mg-gui-dark) var(--mg-gui-dark) var(--mg-gui-light);
  border-radius: 4px;
  box-shadow: 0 0 0 1px var(--mg-gui-edge);
  color: var(--mg-gui-text);
}

.header {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 4px 12px;
  margin-bottom: 10px;
  font-family: var(--mg-font-pixel);
  font-size: 15px;
}

.station {
  display: inline-flex;
  align-items: center;
  gap: 6px;
}

.station :deep(.mg-slot) {
  background: transparent;
  border-color: transparent;
}

.shape {
  margin-left: auto;
  font-size: 12px;
  opacity: 0.7;
}

.body {
  display: flex;
  align-items: center;
  gap: 16px;
}

.grid {
  display: grid;
  grid-template-columns: repeat(3, 36px);
}

.row {
  display: flex;
}

.furnace {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 2px;
}

.flame {
  width: 26px;
  height: 26px;
  image-rendering: pixelated;
}

.energy {
  font-size: 11px;
  font-weight: 600;
  opacity: 0.75;
}

.arrow {
  width: 44px;
  height: 30px;
  fill: var(--mg-gui-arrow);
  shape-rendering: crispEdges;
}

.footer {
  margin-top: 8px;
  font-size: 12px;
  opacity: 0.75;
}
</style>
