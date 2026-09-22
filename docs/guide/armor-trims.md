# Armor trims

Seven More Gears materials work as armor trim materials. Put one in the material slot of a smithing table with a trim template and any trimmable armor, vanilla or More Gears.

<div class="mg-trims">
  <div class="mg-trim" style="--trim: #9DC6E0"><ItemSlot id="moregears:tin_ingot" size="lg" /><span>Tin</span><code>#9DC6E0</code></div>
  <div class="mg-trim" style="--trim: #F1C232"><ItemSlot id="moregears:bronze_ingot" size="lg" /><span>Bronze</span><code>#F1C232</code></div>
  <div class="mg-trim" style="--trim: #6E6B6B"><ItemSlot id="moregears:steel_ingot" size="lg" /><span>Steel</span><code>#6E6B6B</code></div>
  <div class="mg-trim" style="--trim: #E0115F"><ItemSlot id="moregears:ruby" size="lg" /><span>Ruby</span><code>#E0115F</code></div>
  <div class="mg-trim" style="--trim: #3AAFA9"><ItemSlot id="moregears:echoite_ingot" size="lg" /><span>Echoite</span><code>#3AAFA9</code></div>
  <div class="mg-trim" style="--trim: #9E6590"><ItemSlot id="moregears:titanium_ingot" size="lg" /><span>Titanium</span><code>#9E6590</code></div>
  <div class="mg-trim" style="--trim: #5D3391"><ItemSlot id="moregears:enderite_ingot" size="lg" /><span>Enderite</span><code>#5D3391</code></div>
</div>

The colour is the one the trim material's name uses in the item tooltip. The trim on the armor itself uses a matching palette.

<style>
.mg-trims {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(130px, 1fr));
  gap: 12px;
  margin: 20px 0;
}

.mg-trim {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 6px;
  padding: 14px 10px 12px;
  border: 1px solid var(--vp-c-divider);
  border-bottom: 5px solid var(--trim);
  border-radius: 10px;
  background: linear-gradient(180deg, color-mix(in srgb, var(--trim) 16%, transparent), transparent 70%);
  font-weight: 600;
}

.mg-trim code {
  font-size: 12px;
}
</style>
