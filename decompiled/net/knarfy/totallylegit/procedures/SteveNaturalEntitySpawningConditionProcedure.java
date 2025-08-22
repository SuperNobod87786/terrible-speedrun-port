/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package net.knarfy.totallylegit.procedures;

import net.knarfy.totallylegit.entity.SteveEntity;
import net.knarfy.totallylegit.init.TotallyLegitModGameRules;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SteveNaturalEntitySpawningConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        ServerLevel _serverLevelGR0;
        return world instanceof ServerLevel && (_serverLevelGR0 = (ServerLevel)world).getGameRules().getBoolean(TotallyLegitModGameRules.SPAWN_STEVES) && world.getEntitiesOfClass(SteveEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150.0), e -> true).isEmpty();
    }
}

