# Armor

Bronze, steel, ruby, echoite, titanium and enderite each have a full armor set. Copper armor comes from vanilla Minecraft, and More Gears gives the full set [lightning immunity](./special-effects#copper).

<GearStats group="armor" />

## Full sets

| Set | Armor | Toughness | Knockback res. |
| --- | --- | --- | --- |
| <ItemSlot id="minecraft:diamond_chestplate" /> Diamond (vanilla) | 20 | 8 | 0 |
| <ItemSlot id="moregears:bronze_chestplate" /> Bronze | 17 | 0 | 0 |
| <ItemSlot id="moregears:steel_chestplate" /> Steel | 20 | 6 | 0 |
| <ItemSlot id="moregears:ruby_chestplate" /> Ruby | 19 | 4 | 0 |
| <ItemSlot id="moregears:echoite_chestplate" /> Echoite | 23 | 10 | 10 |
| <ItemSlot id="minecraft:netherite_chestplate" /> Netherite (vanilla) | 20 | 12 | 4 |
| <ItemSlot id="moregears:titanium_chestplate" /> Titanium | 24 | 16 | 20 |
| <ItemSlot id="moregears:enderite_chestplate" /> Enderite | 28 | 20 | 40 |

Knockback resistance is shown the way the tooltip adds it up. Anything at 10 or above means you don't get knocked back at all.

## Recipes

Bronze, steel, ruby and echoite armor use the same crafting shapes as vanilla armor. Titanium and enderite armor are [smithing upgrades](/guide/smithing-templates).

### Bronze {.tier .tier-bronze}

<RecipeGrid tier="bronze" group="armor" />

### Steel {.tier .tier-steel}

<RecipeGrid tier="steel" group="armor" />

### Ruby {.tier .tier-ruby}

<RecipeGrid tier="ruby" group="armor" />

### Echoite <Badge type="tip" text="26.3+" /> {.tier .tier-echoite}

<RecipeGrid tier="echoite" group="armor" />

### Titanium {.tier .tier-titanium}

<RecipeGrid tier="titanium" group="armor" />

### Enderite {.tier .tier-enderite}

<RecipeGrid tier="enderite" group="armor" />

## Shields <Badge type="tip" text="26.3+" />

Every tier from bronze up has a shield. They block exactly like a vanilla shield and only differ in how much punishment they take before breaking. The enderite one never breaks at all.

<GearStats group="shields" />

Shields are crafted like the vanilla one, with the tier's ingot in place of the iron, and each can be repaired with its own material. A banner still works on any of them: combine a shield and a banner in a crafting table and the pattern shows up on the front, same as vanilla.

### Recipes

<RecipeGrid tier="bronze" group="shields" />
<RecipeGrid tier="steel" group="shields" />
<RecipeGrid tier="ruby" group="shields" />
<RecipeGrid tier="echoite" group="shields" />
<RecipeGrid tier="titanium" group="shields" />
<RecipeGrid tier="enderite" group="shields" />

## Enderite Elytra <Badge type="tip" text="26.3+" />

<div class="mg-effects">
  <div class="mg-effect tier-enderite">
    <strong>Unbreakable and fireproof</strong>
    It never wears out, so you never need phantom membranes, and it survives fire and lava when dropped.
  </div>
</div>

Upgrade a vanilla elytra at a smithing table with an [Enderite Upgrade](/guide/smithing-templates#enderite-upgrade) and an enderite ingot. **Flight is unchanged** — it glides exactly like a vanilla elytra, it just never breaks.

<RecipeGrid :ids="['minecraft:enderite_elytra_smithing']" />
