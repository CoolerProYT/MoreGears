<script setup lang="ts">
import { withBase } from 'vitepress'
import ItemSlot from './ItemSlot.vue'

// How each material is obtained. Netherite is vanilla, but the titanium upgrade starts from it.
const STEPS = [
  {
    tier: 'copper',
    name: 'Copper',
    material: 'minecraft:copper_ingot',
    how: 'Vanilla copper, plus a bow and arrows',
    link: '/gear/tiers#copper',
  },
  {
    tier: 'bronze',
    name: 'Bronze',
    material: 'moregears:bronze_ingot',
    how: 'Alloy copper with tin',
    link: '/gear/tiers#bronze',
  },
  { tier: 'steel', name: 'Steel', material: 'moregears:steel_ingot', how: 'Alloy iron with coal', link: '/gear/tiers#steel' },
  { tier: 'ruby', name: 'Ruby', material: 'moregears:ruby', how: 'Mined deep in the Overworld', link: '/gear/tiers#ruby' },
  {
    tier: 'echoite',
    name: 'Echoite',
    material: 'moregears:echoite_ingot',
    how: 'Alloy an echo shard with a diamond',
    link: '/gear/tiers#echoite',
  },
  {
    tier: 'netherite',
    name: 'Netherite',
    material: 'minecraft:netherite_ingot',
    how: 'Vanilla, the base for the next upgrade',
    link: '',
  },
  {
    tier: 'titanium',
    name: 'Titanium',
    material: 'moregears:titanium_ingot',
    how: 'Nether ore, upgrades netherite gear',
    link: '/gear/tiers#titanium',
  },
  {
    tier: 'enderite',
    name: 'Enderite',
    material: 'moregears:enderite_ingot',
    how: 'End ore, upgrades titanium gear',
    link: '/gear/tiers#enderite',
  },
]
</script>

<template>
  <ol class="mg-ladder">
    <li v-for="step in STEPS" :key="step.tier" :class="[`tier-${step.tier}`, { vanilla: !step.link }]">
      <component :is="step.link ? 'a' : 'div'" :href="step.link ? withBase(step.link) : undefined" class="step">
        <ItemSlot :id="step.material" size="lg" />
        <span class="name">{{ step.name }}</span>
        <span class="how">{{ step.how }}</span>
      </component>
    </li>
  </ol>
</template>

<style scoped>
.mg-ladder {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(120px, 1fr));
  gap: 10px;
  margin: 20px 0;
  padding: 0;
  list-style: none;
  counter-reset: step;
}

.mg-ladder li {
  margin: 0;
  counter-increment: step;
}

.step {
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 6px;
  height: 100%;
  padding: 16px 10px 12px;
  text-align: center;
  border: 1px solid var(--vp-c-divider);
  border-top: 4px solid var(--tier);
  border-radius: 10px;
  background: linear-gradient(180deg, color-mix(in srgb, var(--tier) 14%, transparent), transparent 60%);
  color: inherit;
  text-decoration: none !important;
  transition:
    transform 0.15s,
    box-shadow 0.15s;
}

a.step:hover {
  transform: translateY(-3px);
  box-shadow: 0 8px 20px -10px var(--tier);
}

.step::before {
  content: counter(step);
  position: absolute;
  top: 6px;
  left: 8px;
  font: 600 11px/1 var(--vp-font-family-mono);
  color: var(--vp-c-text-3);
}

.vanilla .step {
  border-style: dashed;
  border-top-style: solid;
  opacity: 0.8;
}

.name {
  font-weight: 700;
  color: var(--vp-c-text-1);
}

.how {
  font-size: 12px;
  line-height: 1.4;
  color: var(--vp-c-text-2);
}
</style>
