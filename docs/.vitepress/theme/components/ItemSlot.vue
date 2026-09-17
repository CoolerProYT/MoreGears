<script setup lang="ts">
import { computed, onUnmounted, ref, watch } from 'vue'
import { isModItem, itemIcon, itemName } from '../moregears'

const props = withDefaults(
  defineProps<{
    id?: string | null
    /** Several items cycle in one slot, like JEI does for alternative ingredients. */
    ids?: string[]
    count?: number
    label?: boolean
    size?: 'sm' | 'md' | 'lg'
    /** Epic items (the maces) get a magenta name, as in game. */
    epic?: boolean
  }>(),
  { id: null, ids: () => [], count: 1, label: false, size: 'md', epic: false },
)

const items = computed(() => (props.ids.length ? props.ids : props.id ? [props.id] : []))
const index = ref(0)
const current = computed(() => items.value[index.value % Math.max(items.value.length, 1)] ?? null)

let timer: ReturnType<typeof setInterval> | undefined
watch(
  () => items.value.length,
  (length) => {
    clearInterval(timer)
    index.value = 0
    if (length > 1 && typeof window !== 'undefined') timer = setInterval(() => index.value++, 1200)
  },
  { immediate: true },
)
onUnmounted(() => clearInterval(timer))

const name = computed(() => (current.value ? itemName(current.value) : ''))
const src = computed(() => (current.value ? itemIcon(current.value) : null))
const epic = computed(() => props.epic || /_mace$/.test(current.value ?? ''))

// Falls back to initials when an item has no icon or the hosted icon fails to load.
const failed = ref(false)
watch(src, () => (failed.value = false))
const initials = computed(() =>
  name.value
    .split(' ')
    .filter((word) => /^[A-Z]/.test(word))
    .slice(0, 2)
    .map((word) => word[0])
    .join(''),
)

// The tooltip is teleported to <body> so tables and scroll containers never clip it.
const slot = ref<HTMLElement>()
const tip = ref<{ x: number; y: number } | null>(null)
function show() {
  if (!current.value || !slot.value) return
  const rect = slot.value.getBoundingClientRect()
  tip.value = { x: rect.left + rect.width / 2, y: rect.top }
}
const hide = () => (tip.value = null)
</script>

<template>
  <span class="mg-item" :class="[`size-${size}`, { 'with-label': label }]">
    <span
      ref="slot"
      class="mg-slot"
      :aria-label="name"
      role="img"
      :tabindex="current ? 0 : -1"
      @mouseenter="show"
      @mouseleave="hide"
      @focus="show"
      @blur="hide"
    >
      <img v-if="src && !failed" class="pixelated" :src="src" alt="" loading="lazy" @error="failed = true" />
      <span v-else-if="current" class="mg-initials">{{ initials }}</span>
      <span v-if="count > 1" class="mg-count">{{ count }}</span>
    </span>
    <span v-if="label && current" class="mg-label">{{ name }}</span>
    <Teleport v-if="tip" to="body">
      <span class="mg-tooltip" :style="{ left: `${tip.x}px`, top: `${tip.y}px` }" role="tooltip">
        <span class="mg-tooltip-name" :class="{ epic }">{{ name }}</span>
        <span class="mg-tooltip-mod">{{ isModItem(current!) ? 'More Gears' : 'Minecraft' }}</span>
      </span>
    </Teleport>
  </span>
</template>

<style scoped>
.mg-item {
  display: inline-flex;
  align-items: center;
  gap: 8px;
  vertical-align: middle;
  --slot: 36px;
  --icon: 32px;
}

.size-sm {
  --slot: 28px;
  --icon: 24px;
}

.size-lg {
  --slot: 52px;
  --icon: 44px;
}

.mg-slot {
  position: relative;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  width: var(--slot);
  height: var(--slot);
  flex: none;
  background: var(--mg-slot-bg);
  border: 2px solid;
  border-color: var(--mg-slot-dark) var(--mg-slot-light) var(--mg-slot-light) var(--mg-slot-dark);
  outline: none;
}

.mg-slot:hover,
.mg-slot:focus-visible {
  box-shadow: inset 0 0 0 100px rgba(255, 255, 255, 0.28);
}

.mg-slot img {
  width: var(--icon);
  height: var(--icon);
}

.mg-initials {
  font: 600 12px/1 var(--vp-font-family-mono);
  color: #fff;
  text-shadow: 1px 1px 0 #3f3f3f;
}

.mg-count {
  position: absolute;
  right: 1px;
  bottom: -1px;
  font: 700 13px/1 var(--mg-font-pixel);
  color: #fff;
  text-shadow: 2px 2px 0 #3f3f3f;
}

.mg-label {
  font-weight: 500;
}
</style>

<style>
/* Unscoped: the tooltip lives under <body>. */
.mg-tooltip {
  position: fixed;
  z-index: 100;
  transform: translate(-50%, calc(-100% - 8px));
  display: flex;
  flex-direction: column;
  gap: 2px;
  padding: 5px 8px 6px;
  background: rgba(16, 0, 16, 0.94);
  border: 2px solid #25015b;
  outline: 2px solid rgba(16, 0, 16, 0.94);
  border-radius: 2px;
  font-family: var(--mg-font-pixel);
  font-size: 14px;
  line-height: 1.2;
  white-space: nowrap;
  pointer-events: none;
}

.mg-tooltip-name {
  color: #fff;
  text-shadow: 2px 2px 0 #3e3e3e;
}

.mg-tooltip-name.epic {
  color: #ff55ff;
  text-shadow: 2px 2px 0 #3f153f;
}

.mg-tooltip-mod {
  color: #5555ff;
  font-style: italic;
  text-shadow: 2px 2px 0 #15153f;
}
</style>
