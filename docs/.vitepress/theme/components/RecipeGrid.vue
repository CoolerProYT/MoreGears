<script setup lang="ts">
import { computed } from 'vue'
import { armorPieces, data, type WeaponKind, weapons } from '../moregears'
import RecipeCard from './RecipeCard.vue'

const GROUPS: Record<string, WeaponKind[]> = {
  tools: ['sword', 'axe', 'pickaxe', 'shovel', 'hoe', 'spear', 'mace', 'trident'],
  ranged: ['bow', 'crossbow', 'arrow'],
  shields: ['shield'],
}

/** Either a list of recipe ids, or every recipe that makes a tier's tools, armor, ranged gear or shield. */
const props = defineProps<{ ids?: string[]; tier?: string; group?: 'tools' | 'armor' | 'ranged' | 'shields' }>()

const recipeIds = computed(() => {
  if (props.ids) return props.ids
  if (!props.tier || !props.group) return []
  const items =
    props.group === 'armor' ? armorPieces(props.tier).map((a) => a.id) : weapons(GROUPS[props.group], props.tier).map((w) => w.id)
  // Special recipes (banner decoration) have no shape to draw, so they never get a card.
  const shown = (type: string) =>
    (type.startsWith('minecraft:crafting') && !type.startsWith('minecraft:crafting_special')) ||
    type === 'minecraft:smithing_transform'
  return items.flatMap((item) =>
    data.recipes.filter((r) => r.result.id === item && shown(r.type)).map((r) => r.id),
  )
})
</script>

<template>
  <div class="mg-recipe-grid">
    <RecipeCard v-for="id in recipeIds" :id="id" :key="id" />
  </div>
</template>

<style scoped>
.mg-recipe-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(290px, 1fr));
  gap: 4px 16px;
  margin: 12px 0;
}

.mg-recipe-grid :deep(.mg-recipe) {
  display: flex;
}
</style>
