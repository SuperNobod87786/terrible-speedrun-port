/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.projectile.AbstractArrow
 *  net.minecraft.world.entity.projectile.AbstractArrow$Pickup
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.enchantment.Enchantments
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 */
package net.knarfy.totallylegit.procedures;

import net.knarfy.totallylegit.entity.OneCycleBedProjectileEntity;
import net.knarfy.totallylegit.init.TotallyLegitModEntities;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

public class OneCycleBedPlayerFinishesUsingItemProcedure {
    public static void execute(Entity entity) {
        if (entity == null) {
            return;
        }
        Entity _shootFrom = entity;
        Level projectileLevel = _shootFrom.level();
        if (!projectileLevel.isClientSide()) {
            AbstractArrow _entityToSpawn = OneCycleBedPlayerFinishesUsingItemProcedure.initArrowProjectile(new OneCycleBedProjectileEntity((EntityType<? extends OneCycleBedProjectileEntity>)((EntityType)TotallyLegitModEntities.ONE_CYCLE_BED_PROJECTILE.get()), 0.0, 0.0, 0.0, projectileLevel, OneCycleBedPlayerFinishesUsingItemProcedure.createArrowWeaponItemStack(projectileLevel, 4, (byte)0)), entity, 1000.0f, true, false, true, AbstractArrow.Pickup.ALLOWED);
            _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
            _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5.0f, 0.0f);
            projectileLevel.addFreshEntity((Entity)_entityToSpawn);
        }
    }

    private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
        entityToSpawn.setOwner(shooter);
        entityToSpawn.setBaseDamage((double)damage);
        if (silent) {
            entityToSpawn.setSilent(true);
        }
        if (fire) {
            entityToSpawn.igniteForSeconds(100.0f);
        }
        if (particles) {
            entityToSpawn.setCritArrow(true);
        }
        entityToSpawn.pickup = pickup;
        return entityToSpawn;
    }

    private static ItemStack createArrowWeaponItemStack(Level level, int knockback, byte piercing) {
        ItemStack weapon = new ItemStack((ItemLike)Items.ARROW);
        if (knockback > 0) {
            weapon.enchant((Holder)level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), knockback);
        }
        if (piercing > 0) {
            weapon.enchant((Holder)level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING), (int)piercing);
        }
        return weapon;
    }
}

