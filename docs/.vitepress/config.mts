import { defineConfig } from 'vitepress'

// GitHub Pages serves a project site from /<repository>/. For a custom domain or a user site, build with DOCS_BASE=/.
const base = process.env.DOCS_BASE ?? '/MoreGears/'
const ICON = 'https://storage.googleapis.com/coolerpromc/textures/moregears/enderite_sword.png'

export default defineConfig({
  title: 'More Gears',
  description: 'Six new tiers of tools, weapons and armor for Minecraft, from copper bows to unbreakable enderite.',
  base,
  cleanUrls: true,
  srcExclude: ['README.md', 'scripts/**'],
  head: [['link', { rel: 'icon', type: 'image/png', href: ICON }]],
  themeConfig: {
    logo: { src: ICON, alt: '' },
    nav: [
      { text: 'Guide', link: '/guide/getting-started' },
      { text: 'Gear', link: '/gear/tiers' },
      { text: 'Stats', link: '/gear/tools' },
      {
        text: 'Download',
        items: [
          { text: 'CurseForge', link: 'https://www.curseforge.com/minecraft/mc-mods/more-gears' },
          { text: 'Modrinth', link: 'https://modrinth.com/mod/more-gears' },
        ],
      },
    ],
    sidebar: [
      {
        text: 'Guide',
        items: [
          { text: 'Getting started', link: '/guide/getting-started' },
          { text: 'Ore generation', link: '/guide/ores' },
          { text: 'Materials', link: '/guide/materials' },
          { text: 'Alloy Smelter', link: '/guide/alloy-smelter' },
          { text: 'Smithing templates', link: '/guide/smithing-templates' },
          { text: 'Armor trims', link: '/guide/armor-trims' },
        ],
      },
      {
        text: 'Gear',
        items: [
          { text: 'Tiers', link: '/gear/tiers' },
          { text: 'Tools & weapons', link: '/gear/tools' },
          { text: 'Armor', link: '/gear/armor' },
          { text: 'Bows & arrows', link: '/gear/ranged' },
          { text: 'Special effects', link: '/gear/special-effects' },
        ],
      },
      { text: 'FAQ', link: '/faq' },
    ],
    socialLinks: [
      { icon: 'github', link: 'https://github.com/CoolerProYT/MoreGears' },
      { icon: 'discord', link: 'https://discord.com/invite/hvFfqsqQm8' },
    ],
    search: { provider: 'local' },
    outline: { level: [2, 3] },
    footer: {
      message: 'Made by CoolerProMC. Not an official Minecraft product.',
      copyright: 'More Gears · All rights reserved',
    },
  },
})
