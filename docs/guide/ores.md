# Ore generation

More Gears adds four ores, two of them with deepslate variants. Each one drops a raw material you smelt into an ingot (or a gem, for ruby), and Fortune gives extra drops, the same way it does for vanilla ores. Silk Touch gives you the ore block itself.

The chart on each card shows where the ore spawns. The wider the shape, the more ore you'll find at that height.

## Overworld

### Tin

<OreCard id="tin_ore" tool="Copper pickaxe or better" tool-icon="minecraft:copper_pickaxe" />

Tin is the most common ore in the mod, and you'll mostly use it to alloy [bronze](./materials#bronze-ingot). Every biome has it, so you'll run into it while you look for iron.

<div class="mg-gallery">
  <figure><img src="/ore-generation/tin.jpg" alt="Tin ore in a cave wall" loading="lazy" /><figcaption>Tin Ore</figcaption></figure>
  <figure><img src="/ore-generation/deepslate_tin.jpg" alt="Deepslate tin ore in a cave wall" loading="lazy" /><figcaption>Deepslate Tin Ore</figcaption></figure>
</div>

### Ruby

<OreCard id="ruby_ore" tool="Bronze pickaxe or better (iron isn't enough)" tool-icon="moregears:bronze_pickaxe" />

Ruby veins are smaller than tin veins but show up just as often. Ruby gear is a step below diamond. You'll need a bronze pickaxe, so make bronze first.

<div class="mg-gallery">
  <figure><img src="/ore-generation/ruby.jpg" alt="Ruby ore in a cave wall" loading="lazy" /><figcaption>Ruby Ore</figcaption></figure>
  <figure><img src="/ore-generation/deepslate_ruby.jpg" alt="Deepslate ruby ore in a cave wall" loading="lazy" /><figcaption>Deepslate Ruby Ore</figcaption></figure>
</div>

## The Nether

### Titanium

<OreCard id="nether_titanium_ore" tool="Any pickaxe" tool-icon="minecraft:iron_pickaxe" />

Titanium is about as rare as ancient debris: only a few small veins per chunk, spread evenly from the bottom of the Nether up to Y 25. The worldgen range starts at Y −64, but the Nether floor is Y 0, so in practice you'll find it between Y 0 and 25.

::: tip Blast mining works
Titanium ore has the same blast resistance as ancient debris, so TNT and beds won't destroy it. Blow open a tunnel around Y 15 and look for the ore in the crater, the same way you'd hunt debris.
:::

<div class="mg-gallery">
  <figure><img src="/ore-generation/titanium.jpg" alt="Nether titanium ore in netherrack" loading="lazy" /><figcaption>Nether Titanium Ore</figcaption></figure>
</div>

## The End

### Enderite

<OreCard id="end_enderite_ore" tool="Titanium pickaxe or better" tool-icon="moregears:titanium_pickaxe" />

Enderite only replaces end stone. The End is mostly empty space, so the outer islands are where you'll find it. You'll need a titanium pickaxe, so upgrade one before you leave the Nether behind. Enderite ore is blast resistant too.

<div class="mg-gallery">
  <figure><img src="/ore-generation/enderite.jpg" alt="End enderite ore in end stone" loading="lazy" /><figcaption>End Enderite Ore</figcaption></figure>
</div>

## Tags

All ores are in the common `c:ores/<material>` block tags (`c:ores/tin`, `c:ores/ruby`, `c:ores/titanium`, `c:ores/enderite`), so ore processors from other mods can recognise them.
