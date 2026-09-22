# Materials

Every tier is crafted from one material. Four come from ores and three are alloys you make in the [Alloy Smelter](./alloy-smelter).

| Material | Source | Used for |
| --- | --- | --- |
| <ItemSlot id="moregears:tin_ingot" label /> | Tin ore | Bronze, armor trims |
| <ItemSlot id="moregears:bronze_ingot" label /> | Copper + tin, alloyed | Bronze gear |
| <ItemSlot id="moregears:steel_ingot" label /> | Iron + coal, alloyed | Steel gear |
| <ItemSlot id="moregears:ruby" label /> | Ruby ore | Ruby gear |
| <ItemSlot id="moregears:echoite_ingot" label /> | Echo shard + diamond, alloyed | Echoite gear |
| <ItemSlot id="moregears:titanium_ingot" label /> | Nether titanium ore | Titanium upgrades, bow, arrows |
| <ItemSlot id="moregears:enderite_ingot" label /> | End enderite ore | Enderite upgrades, bow, arrows |

All seven also work as [armor trim materials](./armor-trims).

## Smelted from ore

Raw materials and ore blocks smelt in a furnace or a blast furnace. More Gears gives the blast furnace recipes the same 10 second cook time, so either works. The input slot below cycles through everything you can smelt.

### Tin Ingot

<RecipeCard result="moregears:tin_ingot" />

### Ruby

<RecipeCard result="moregears:ruby" />

### Titanium Ingot

<RecipeCard result="moregears:titanium_ingot" />

Nine titanium nuggets craft back into an ingot, and an ingot splits into nine nuggets. You'll need nuggets for both [smithing templates](./smithing-templates).

<RecipeGrid :ids="['titanium_nugget_from_titanium_ingot', 'titanium_ingot_from_titanium_nugget']" />

### Enderite Ingot

<RecipeCard result="moregears:enderite_ingot" />

## Alloyed

Alloys need an [Alloy Smelter](./alloy-smelter). Each recipe gives two ingots.

### Bronze Ingot

<RecipeCard id="alloy_smelting/bronze_ingot_from_alloy_smelting" />

### Steel Ingot

<RecipeCard id="alloy_smelting/steel_ingot_from_alloy_smelting" />

### Echoite Ingot <Badge type="tip" text="26.3+" />

<RecipeCard id="alloy_smelting/echoite_ingot_from_alloy_smelting" />

Echo shards only drop from ancient city loot chests, so plan a trip to the Deep Dark before you count on echoite.
