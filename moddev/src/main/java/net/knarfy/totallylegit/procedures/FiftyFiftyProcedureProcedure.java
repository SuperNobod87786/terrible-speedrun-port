/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.level.LevelAccessor
 *  net.neoforged.bus.api.Event
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.event.entity.living.LivingDeathEvent
 */
package net.knarfy.totallylegit.procedures;

import javax.annotation.Nullable;
import net.knarfy.totallylegit.init.TotallyLegitModGameRules;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@EventBusSubscriber
public class FiftyFiftyProcedureProcedure {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event.getEntity() != null) {
            FiftyFiftyProcedureProcedure.execute((Event)event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z) {
        FiftyFiftyProcedureProcedure.execute(null, world, x, y, z);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
        ServerLevel _serverLevelGR0;
        double pick = 0.0;
        if (world instanceof ServerLevel && (_serverLevelGR0 = (ServerLevel)world).getGameRules().getBoolean(TotallyLegitModGameRules.FIFTY_FIFTY)) {
            Level _level;
            pick = Mth.nextInt((RandomSource)RandomSource.create(), (int)1, (int)2);
            if (pick == 1.0) {
                ItemEntity entityToSpawn;
                ServerLevel _level2;
                if (world instanceof ServerLevel) {
                    _level2 = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level2, x, y, z, new ItemStack((ItemLike)Items.DIAMOND));
                    entityToSpawn.setPickUpDelay(10);
                    _level2.addFreshEntity((Entity)entityToSpawn);
                }
                if (world instanceof ServerLevel) {
                    _level2 = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level2, x, y, z, new ItemStack((ItemLike)Items.DIAMOND));
                    entityToSpawn.setPickUpDelay(10);
                    _level2.addFreshEntity((Entity)entityToSpawn);
                }
                if (world instanceof ServerLevel) {
                    _level2 = (ServerLevel)world;
                    entityToSpawn = new ItemEntity((Level)_level2, x, y, z, new ItemStack((ItemLike)Items.DIAMOND));
                    entityToSpawn.setPickUpDelay(10);
                    _level2.addFreshEntity((Entity)entityToSpawn);
                }
            } else if (pick == 2.0 && world instanceof Level && !(_level = (Level)world).isClientSide()) {
                _level.explode(null, x, y, z, 2.0f, Level.ExplosionInteraction.MOB);
            }
        }
    }
}

