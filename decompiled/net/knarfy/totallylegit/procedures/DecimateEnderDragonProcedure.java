/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.boss.enderdragon.EnderDragon
 *  net.minecraft.world.level.LevelAccessor
 */
package net.knarfy.totallylegit.procedures;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.level.LevelAccessor;

public class DecimateEnderDragonProcedure {
    public static void execute(LevelAccessor world, Entity immediatesourceentity) {
        if (immediatesourceentity == null) {
            return;
        }
        if (immediatesourceentity instanceof EnderDragon) {
            immediatesourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 400.0f);
        }
    }
}

