/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.animal.Chicken
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.neoforged.bus.api.Event
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.event.tick.EntityTickEvent$Pre
 */
package net.knarfy.totallylegit.procedures;

import javax.annotation.Nullable;
import net.knarfy.totallylegit.init.TotallyLegitModGameRules;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber
public class ScreamsOfChickensProcedure {
    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Pre event) {
        ScreamsOfChickensProcedure.execute((Event)event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        ScreamsOfChickensProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        ServerLevel _serverLevelGR0;
        if (entity == null) {
            return;
        }
        if (world instanceof ServerLevel && (_serverLevelGR0 = (ServerLevel)world).getGameRules().getBoolean(TotallyLegitModGameRules.CHICKENS_SCREAM) && entity instanceof Chicken && Mth.nextInt((RandomSource)RandomSource.create(), (int)1, (int)200) == 1 && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
                _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"totally_legit:screaming")), SoundSource.AMBIENT, 1.0f, 1.0f);
            } else {
                _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"totally_legit:screaming")), SoundSource.AMBIENT, 1.0f, 1.0f, false);
            }
        }
    }
}

