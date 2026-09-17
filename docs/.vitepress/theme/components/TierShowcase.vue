<script setup lang="ts">
import { computed } from 'vue'
import { tierItems } from '../moregears'
import ItemSlot from './ItemSlot.vue'

/** Every item of a tier in a hotbar-style strip. `extra` adds items that belong to the tier but aren't mod gear. */
const props = withDefaults(defineProps<{ tier: string; extra?: string[] }>(), { extra: () => [] })

const items = computed(() => [...props.extra, ...tierItems(props.tier)])
</script>

<template>
  <div class="mg-showcase" :class="`tier-${tier}`">
    <ItemSlot v-for="id in items" :id="id" :key="id" size="lg" />
  </div>
</template>

<style scoped>
.mg-showcase {
  display: flex;
  flex-wrap: wrap;
  gap: 0;
  width: fit-content;
  max-width: 100%;
  margin: 16px 0;
  padding: 6px;
  background: var(--mg-gui-bg);
  border: 3px solid;
  border-color: var(--mg-gui-light) var(--mg-gui-dark) var(--mg-gui-dark) var(--mg-gui-light);
  border-radius: 4px;
  box-shadow:
    0 0 0 1px var(--mg-gui-edge),
    0 6px 20px -8px var(--tier);
}
</style>
