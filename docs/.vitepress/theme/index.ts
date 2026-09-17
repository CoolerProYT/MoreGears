import DefaultTheme from 'vitepress/theme'
import type { Theme } from 'vitepress'
import GearStats from './components/GearStats.vue'
import ItemSlot from './components/ItemSlot.vue'
import OreCard from './components/OreCard.vue'
import RecipeCard from './components/RecipeCard.vue'
import RecipeGrid from './components/RecipeGrid.vue'
import TierLadder from './components/TierLadder.vue'
import TierShowcase from './components/TierShowcase.vue'
import VersionTable from './components/VersionTable.vue'
import './style.css'

export default {
  extends: DefaultTheme,
  enhanceApp({ app }) {
    app.component('GearStats', GearStats)
    app.component('ItemSlot', ItemSlot)
    app.component('OreCard', OreCard)
    app.component('RecipeCard', RecipeCard)
    app.component('RecipeGrid', RecipeGrid)
    app.component('TierLadder', TierLadder)
    app.component('TierShowcase', TierShowcase)
    app.component('VersionTable', VersionTable)
  },
} satisfies Theme
