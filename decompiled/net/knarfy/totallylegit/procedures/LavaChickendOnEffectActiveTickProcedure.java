/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.LevelAccessor
 */
package net.knarfy.totallylegit.procedures;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class LavaChickendOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        ServerLevel _level;
        LivingEntity _entity;
        if (entity == null) {
            return;
        }
        if (entity instanceof LivingEntity && !(_entity = (LivingEntity)entity).level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1, true, false));
        }
        if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((ParticleOptions)ParticleTypes.LARGE_SMOKE, x, y, z, 5, 0.1, 1.0, 0.1, 0.0);
        }
        if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((ParticleOptions)ParticleTypes.FLAME, x, y, z, 4, 0.1, 1.0, 0.1, 0.0);
        }
    }
}

