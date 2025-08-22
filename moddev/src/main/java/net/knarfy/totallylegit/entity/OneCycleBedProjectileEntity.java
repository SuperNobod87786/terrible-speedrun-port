/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.projectile.AbstractArrow
 *  net.minecraft.world.entity.projectile.ItemSupplier
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.item.enchantment.Enchantments
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package net.knarfy.totallylegit.entity;

import javax.annotation.Nullable;
import net.knarfy.totallylegit.init.TotallyLegitModEntities;
import net.knarfy.totallylegit.procedures.DecimateEnderDragonProcedure;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT, _interface=ItemSupplier.class)
public class OneCycleBedProjectileEntity
extends AbstractArrow
implements ItemSupplier {
    public static final ItemStack PROJECTILE_ITEM = new ItemStack((ItemLike)Items.WHITE_BED);
    private int knockback = 0;

    public OneCycleBedProjectileEntity(EntityType<? extends OneCycleBedProjectileEntity> type, Level world) {
        super(type, world);
    }

    public OneCycleBedProjectileEntity(EntityType<? extends OneCycleBedProjectileEntity> type, double x, double y, double z, Level world, @Nullable ItemStack firedFromWeapon) {
        super(type, x, y, z, world, PROJECTILE_ITEM, firedFromWeapon);
        if (firedFromWeapon != null) {
            this.setKnockback(EnchantmentHelper.getItemEnchantmentLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), (ItemStack)firedFromWeapon));
        }
    }

    public OneCycleBedProjectileEntity(EntityType<? extends OneCycleBedProjectileEntity> type, LivingEntity entity, Level world, @Nullable ItemStack firedFromWeapon) {
        super(type, entity, world, PROJECTILE_ITEM, firedFromWeapon);
        if (firedFromWeapon != null) {
            this.setKnockback(EnchantmentHelper.getItemEnchantmentLevel((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), (ItemStack)firedFromWeapon));
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public ItemStack getItem() {
        return PROJECTILE_ITEM;
    }

    protected ItemStack getDefaultPickupItem() {
        return new ItemStack((ItemLike)Items.WHITE_BED);
    }

    protected void doPostHurtEffects(LivingEntity entity) {
        super.doPostHurtEffects(entity);
        entity.setArrowCount(entity.getArrowCount() - 1);
    }

    public void setKnockback(int knockback) {
        this.knockback = knockback;
    }

    protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
        if ((double)this.knockback > 0.0) {
            double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
            Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale((double)this.knockback * 0.6 * d1);
            if (vec3.lengthSqr() > 0.0) {
                livingEntity.push(vec3.x, 0.1, vec3.z);
            }
        } else {
            super.doKnockback(livingEntity, damageSource);
        }
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 projectilePosition, Vec3 deltaPosition) {
        double d0 = Double.MAX_VALUE;
        Entity entity = null;
        AABB lookupBox = this.getBoundingBox();
        for (Entity entity1 : this.level().getEntities((Entity)this, lookupBox, x$0 -> this.canHitEntity((Entity)x$0))) {
            double d1;
            AABB aabb;
            if (entity1 == this.getOwner() || !(aabb = entity1.getBoundingBox()).intersects(lookupBox) || !((d1 = projectilePosition.distanceToSqr(projectilePosition)) < d0)) continue;
            entity = entity1;
            d0 = d1;
        }
        return entity == null ? null : new EntityHitResult(entity);
    }

    public void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        DecimateEnderDragonProcedure.execute((LevelAccessor)this.level(), (Entity)this);
    }

    public void tick() {
        super.tick();
        if (this.isInGround()) {
            this.discard();
        }
    }

    public static OneCycleBedProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source) {
        return OneCycleBedProjectileEntity.shoot(world, entity, source, 1.0f, 5.0, 5);
    }

    public static OneCycleBedProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
        return OneCycleBedProjectileEntity.shoot(world, entity, source, pullingPower * 1.0f, 5.0, 5);
    }

    public static OneCycleBedProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
        OneCycleBedProjectileEntity entityarrow = new OneCycleBedProjectileEntity((EntityType<? extends OneCycleBedProjectileEntity>)((EntityType)TotallyLegitModEntities.ONE_CYCLE_BED_PROJECTILE.get()), entity, world, null);
        entityarrow.shoot(entity.getViewVector((float)1.0f).x, entity.getViewVector((float)1.0f).y, entity.getViewVector((float)1.0f).z, power * 2.0f, 0.0f);
        entityarrow.setSilent(true);
        entityarrow.setCritArrow(true);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(knockback);
        world.addFreshEntity((Entity)entityarrow);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.bamboo_wood.place")), SoundSource.PLAYERS, 1.0f, 1.0f / (random.nextFloat() * 0.5f + 1.0f) + power / 2.0f);
        return entityarrow;
    }

    public static OneCycleBedProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
        OneCycleBedProjectileEntity entityarrow = new OneCycleBedProjectileEntity((EntityType<? extends OneCycleBedProjectileEntity>)((EntityType)TotallyLegitModEntities.ONE_CYCLE_BED_PROJECTILE.get()), entity, entity.level(), null);
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + (double)target.getEyeHeight() - 1.1;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * (double)0.2f, dz, 2.0f, 12.0f);
        entityarrow.setSilent(true);
        entityarrow.setBaseDamage(5.0);
        entityarrow.setKnockback(5);
        entityarrow.setCritArrow(true);
        entity.level().addFreshEntity((Entity)entityarrow);
        entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.bamboo_wood.place")), SoundSource.PLAYERS, 1.0f, 1.0f / (RandomSource.create().nextFloat() * 0.5f + 1.0f));
        return entityarrow;
    }
}

