package com.coolerpromc.moregears;

import com.coolerpromc.moregears.block.MGBlocks;
import com.coolerpromc.moregears.block.entity.MGBlockEntities;
import com.coolerpromc.moregears.entity.MGEntities;
import com.coolerpromc.moregears.event.MGCopperArmorEvent;
import com.coolerpromc.moregears.event.MGEnderiteArmorEvent;
import com.coolerpromc.moregears.item.MGCreativeTab;
import com.coolerpromc.moregears.item.MGItems;
import com.coolerpromc.moregears.recipe.MGRecipes;
import com.coolerpromc.moregears.screen.MGMenuTypes;
import com.coolerpromc.moregears.worldgen.MGWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class MoreGears implements ModInitializer {
	public static final String MODID = "moregears";

	@Override
	public void onInitialize() {
		MGCopperArmorEvent.preventLightningBolt();
		MGEnderiteArmorEvent.onPlayerHurt();

		MGItems.init();
		MGEntities.init();
		MGBlocks.init();
		MGBlockEntities.init();
		MGCreativeTab.init();
		MGRecipes.init();
		MGMenuTypes.init();
		MGWorldGeneration.generateModWorldGen();

		DispenserBlock.registerBehavior(MGItems.COPPER_ARROW, new ProjectileDispenserBehavior() {
			protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
				ArrowEntity arrowEntity = new ArrowEntity(world, position.getX(), position.getY(), position.getZ());
				arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
				return arrowEntity;
			}
		});
		DispenserBlock.registerBehavior(MGItems.BRONZE_ARROW, new ProjectileDispenserBehavior() {
			protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
				ArrowEntity arrowEntity = new ArrowEntity(world, position.getX(), position.getY(), position.getZ());
				arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
				return arrowEntity;
			}
		});
		DispenserBlock.registerBehavior(MGItems.STEEL_ARROW, new ProjectileDispenserBehavior() {
			protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
				ArrowEntity arrowEntity = new ArrowEntity(world, position.getX(), position.getY(), position.getZ());
				arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
				return arrowEntity;
			}
		});
		DispenserBlock.registerBehavior(MGItems.RUBY_ARROW, new ProjectileDispenserBehavior() {
			protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
				ArrowEntity arrowEntity = new ArrowEntity(world, position.getX(), position.getY(), position.getZ());
				arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
				return arrowEntity;
			}
		});
		DispenserBlock.registerBehavior(MGItems.TITANIUM_ARROW, new ProjectileDispenserBehavior() {
			protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
				ArrowEntity arrowEntity = new ArrowEntity(world, position.getX(), position.getY(), position.getZ());
				arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
				return arrowEntity;
			}
		});
		DispenserBlock.registerBehavior(MGItems.ENDERITE_ARROW, new ProjectileDispenserBehavior() {
			protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
				ArrowEntity arrowEntity = new ArrowEntity(world, position.getX(), position.getY(), position.getZ());
				arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
				return arrowEntity;
			}
		});
	}
}