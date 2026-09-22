# Smithing templates

Titanium and enderite gear isn't crafted from scratch. You upgrade it at a smithing table, the same way diamond gear becomes netherite:

<div class="mg-effects">
  <div class="mg-effect tier-netherite"><strong>Netherite gear</strong>Vanilla, the starting point.</div>
  <div class="mg-effect tier-titanium"><strong>→ Titanium gear</strong>Titanium Upgrade + a titanium ingot.</div>
  <div class="mg-effect tier-enderite"><strong>→ Enderite gear</strong>Enderite Upgrade + an enderite ingot.</div>
</div>

Both templates work on helmets, chestplates, leggings, boots, swords, pickaxes, axes, shovels, hoes, spears and maces. The Enderite Upgrade also takes a vanilla **trident** and a vanilla **elytra** <Badge type="tip" text="26.3+" />. Bows, crossbows, arrows and shields are crafted normally, see [Bows & arrows](/gear/ranged) and [Armor](/gear/armor#shields).

## Titanium Upgrade

<ItemSlot id="moregears:titanium_upgrade_smithing_template" size="lg" label />

Upgrades **netherite** gear to titanium. Titanium maces start from a vanilla **mace**, since there's no netherite mace.

### Crafting

Make your first template from a vanilla Netherite Upgrade. After that, duplicate it with blackstone for two templates.

<RecipeGrid :ids="['titanium_upgrade_smithing_template_from_netherite_smithing_template', 'moregears:titanium_upgrade_smithing_template']" />

### Upgrades

<RecipeGrid :ids="['titanium_sword_smithing', 'titanium_pickaxe_smithing', 'titanium_axe_smithing', 'titanium_shovel_smithing', 'titanium_hoe_smithing', 'titanium_spear_smithing', 'titanium_mace_smithing', 'titanium_helmet_smithing', 'titanium_chestplate_smithing', 'titanium_leggings_smithing', 'titanium_boots_smithing']" />

## Enderite Upgrade

<ItemSlot id="moregears:enderite_upgrade_smithing_template" size="lg" label />

Upgrades **titanium** gear to enderite. The trident and elytra <Badge type="tip" text="26.3+" /> are the exceptions: they start from their **vanilla** versions, since there's no titanium one of either.

### Crafting

Make your first template from a Titanium Upgrade and an enderite ingot. After that, duplicate it with end stone for two templates.

<RecipeGrid :ids="['enderite_upgrade_smithing_template_from_titanium_smithing_template', 'moregears:enderite_upgrade_smithing_template']" />

::: tip Save a Titanium Upgrade
Crafting the first Enderite Upgrade uses up a Titanium Upgrade. Duplicate your titanium template at least once before you make it.
:::

### Upgrades

<RecipeGrid :ids="['enderite_sword_smithing', 'enderite_pickaxe_smithing', 'enderite_axe_smithing', 'enderite_shovel_smithing', 'enderite_hoe_smithing', 'enderite_spear_smithing', 'enderite_mace_smithing', 'enderite_trident_smithing', 'enderite_elytra_smithing', 'enderite_helmet_smithing', 'enderite_chestplate_smithing', 'enderite_leggings_smithing', 'enderite_boots_smithing']" />
