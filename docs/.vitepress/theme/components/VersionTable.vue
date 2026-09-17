<script setup lang="ts">
import { withBase } from 'vitepress'

// Newest first. `fixes`: whether the version still gets bug fixes.
const VERSIONS = [
  { minecraft: '26.3', loaders: ['neoforge', 'fabric'], version: '26.3.0', fixes: true },
  { minecraft: '26.2', loaders: ['neoforge', 'fabric'], version: '26.2.0', fixes: true },
  { minecraft: '26.1.2', loaders: ['neoforge', 'fabric'], version: '26.1.2.0', fixes: true },
  { minecraft: '1.21.11', loaders: ['neoforge', 'fabric'], version: '2.3.0', fixes: false },
  { minecraft: '1.21.10', loaders: ['neoforge', 'fabric'], version: '2.2.0', fixes: false },
  { minecraft: '1.21.8', loaders: ['neoforge', 'fabric'], version: '2.1.0', fixes: false },
  { minecraft: '1.21.5', loaders: ['neoforge', 'fabric'], version: '2.1.0', fixes: false },
  { minecraft: '1.21.4', loaders: ['neoforge', 'fabric'], version: '2.1.0', fixes: false },
  { minecraft: '1.21.1', loaders: ['neoforge', 'fabric'], version: '2.1.0', fixes: false },
  { minecraft: '1.20.1', loaders: ['forge', 'fabric'], version: '2.1.0', fixes: false },
]

const LOADERS: Record<string, string> = { neoforge: 'NeoForge', fabric: 'Fabric', forge: 'Forge' }
</script>

<template>
  <div class="mg-versions">
    <table>
      <thead>
        <tr>
          <th>Minecraft</th>
          <th>Loaders</th>
          <th>Latest mod version</th>
          <th>Bug fixes</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(v, i) in VERSIONS" :key="v.minecraft">
          <td>
            <strong>{{ v.minecraft }}</strong>
            <span v-if="i === 0" class="latest">Latest</span>
          </td>
          <td>
            <span class="loaders">
              <img
                v-for="loader in v.loaders"
                :key="loader"
                :src="withBase(`/loaders/${loader}.png`)"
                :alt="LOADERS[loader]"
                :title="LOADERS[loader]"
              />
            </span>
          </td>
          <td>
            <code>{{ v.version }}</code>
          </td>
          <td>
            <span :class="['fixes', v.fixes ? 'yes' : 'no']">{{ v.fixes ? 'Yes' : 'No' }}</span>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
.mg-versions table {
  display: table;
  width: 100%;
}

td {
  vertical-align: middle;
}

.latest {
  margin-left: 8px;
  padding: 1px 7px;
  border-radius: 999px;
  font-size: 11px;
  font-weight: 600;
  color: var(--vp-c-brand-1);
  background: var(--vp-c-brand-soft);
}

.loaders {
  display: flex;
  gap: 8px;
}

.loaders img {
  width: 24px;
  height: 24px;
  object-fit: contain;
}

.fixes {
  font-weight: 600;
}

.fixes.yes {
  color: var(--vp-c-green-1);
}

.fixes.no {
  color: var(--vp-c-text-3);
}
</style>
