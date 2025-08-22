/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.animal.Cat
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.neoforged.bus.api.Event
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.event.tick.EntityTickEvent$Pre
 */
package net.knarfy.totallylegit.procedures;

import javax.annotation.Nullable;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber
public class DaveGivesBlazeRodsProcedure {
    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Pre event) {
        DaveGivesBlazeRodsProcedure.execute((Event)event, (LevelAccessor)event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        DaveGivesBlazeRodsProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }
        if (entity instanceof Cat && entity.getDisplayName().getString().equals("Dave the Magical Cheese Wizard")) {
            ServerLevel _level;
            if (world instanceof ServerLevel) {
                _level = (ServerLevel)world;
                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)Items.BLAZE_ROD));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity((Entity)entityToSpawn);
            }
            if (world instanceof ServerLevel) {
                _level = (ServerLevel)world;
                _level.sendParticles((ParticleOptions)ParticleTypes.SMALL_FLAME, x, y, z, 2, 0.3, 0.3, 0.3, 0.0);
            }
            if (entity instanceof Mob) {
                Mob _entity = (Mob)entity;
                _entity.getNavigation().stop();
            }
        }
    }
}

