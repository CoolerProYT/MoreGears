# More Gears wiki

VitePress site for the mod. Recipes, ore generation, item names and gear stats are read from the mod itself, so regenerate the mod's data before building when it changes.

```bash
./gradlew :neoforge:runData   # from the repository root, when mod data changed
cd docs
npm install
npm run dev                   # syncs data, then serves http://localhost:5173/MoreGears/
npm run build                 # syncs data, then builds to .vitepress/dist
```

`npm run sync` (run automatically by `dev` and `build`) writes `.vitepress/data/data.json`, which is git-ignored. It reads:

- recipes, ore placement and loot tables from `common/src/generated/resources`
- item names from `common/src/main/resources/assets/moregears/lang/en_us.json`
- tool, weapon and armor stats from `MGItems.java`, `MGToolMaterials.java`, `MGArmorMaterials.java` and the armor classes. The script fails loudly if it can't parse them, so a refactor there may need a matching change in `scripts/sync-data.mjs`.

Special effects, the version table (`.vitepress/theme/components/VersionTable.vue`) and the prose are written by hand.

## Textures

Item icons load from `https://storage.googleapis.com/coolerpromc/textures/`: `minecraft/<item>.png` for vanilla and `moregears/<item>.png` for the mod, 1024×1024 with nearest-neighbour scaling. Textures aren't copied into the site, so upload a new item's texture there before it shows up. Block items have no flat texture, so their icons are 3D renders committed in `public/icons/` and uploaded under the same names.

## Publishing

`.github/workflows/docs.yml` builds the site and deploys it to GitHub Pages. See the comments in that file for setup.

`public/*.html` files like `Home.html` redirect links from the old wiki (`/Home`, `/OreGeneration`, ...) to the new pages.
