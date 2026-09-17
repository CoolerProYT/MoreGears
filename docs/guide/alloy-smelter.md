# Alloy Smelter

<ItemSlot id="moregears:alloy_smelter" size="lg" label />

The Alloy Smelter fuses two ingredients into an alloy. It runs on energy: burn fuel in it, or power it from another mod's cables.

## Crafting

<RecipeCard id="alloy_smelter" />

Mine it with a copper pickaxe or better. Anything weaker breaks it without a drop.

## Using it

![Alloy Smelter interface](/gui/alloy_smelter.png){.pixelated width=352}

- **Fuel slot** (left, marked with a lightning bolt): takes anything that burns in a furnace.
- **Energy bar** (far left): shows the stored energy. Hover over it for the exact amount.
- **Input slots** (top): put one ingredient in each. The order doesn't matter.
- **Output slot** (bottom): collect your alloy here.

Each alloy takes **5 seconds** and uses **1,000 FE**.

### Energy

| | Amount |
| --- | --- |
| Energy from fuel | 100 FE per tick of burn time |
| Energy per alloy | 10 FE per tick, 1,000 FE total |
| Storage | 100,000 FE |
| Input from cables | Up to 10,000 FE per tick |

Fuel burns only while the smelter has room for more energy. If the smelter is full, fuel waits in its slot. One piece of coal burns for 80 seconds and gives 160,000 FE, enough for 160 alloys, so a stack of coal lasts a long time.

On NeoForge, the smelter accepts energy from any mod that uses NeoForge's energy API. On Fabric, it accepts energy through [Team Reborn Energy](https://modrinth.com/mod/tech-reborn), which most Fabric tech mods use.

### Automation

Hoppers and item pipes see a different slot on each face:

| Face | Slot | What works |
| --- | --- | --- |
| Top | Fuel | Insert fuel |
| Bottom | Output | Pull out alloys |
| Sides | Inputs | See below |

::: warning Loading ingredients
On NeoForge, pipes and hoppers can't insert ingredients through the sides, so add them by hand. On Fabric, side insertion goes through.
:::

## Recipes

<RecipeGrid :ids="['alloy_smelting/bronze_ingot_from_alloy_smelting', 'alloy_smelting/steel_ingot_from_alloy_smelting']" />

JEI and REI both show these under their own Alloy Smelting category.

## Datapack recipes

Alloy Smelting is a normal recipe type, so datapacks can add recipes. Each ingredient has a `count`, and a recipe can have more than one output.

```json
{
  "type": "moregears:alloy_smelting",
  "ingredients": [
    { "ingredient": "minecraft:copper_ingot", "count": 1 },
    { "ingredient": "moregears:tin_ingot", "count": 1 }
  ],
  "output": [
    { "id": "moregears:bronze_ingot", "count": 2 }
  ]
}
```

Save it as `data/<namespace>/recipe/<name>.json` and run `/reload`.
