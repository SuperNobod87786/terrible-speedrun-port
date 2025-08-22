/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 */
package net.knarfy.totallylegit.procedures;

import net.knarfy.totallylegit.init.TotallyLegitModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class LavaChickenPlayerFinishesUsingItemProcedure {
    public static void execute(Entity entity) {
        LivingEntity _entity;
        if (entity == null) {
            return;
        }
        if (entity instanceof LivingEntity && !(_entity = (LivingEntity)entity).level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(TotallyLegitModMobEffects.LAVA_CHICKEND, 600, 0));
        }
    }
}

