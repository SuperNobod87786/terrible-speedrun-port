/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.LevelAccessor
 *  net.neoforged.bus.api.Event
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent$Finish
 */
package net.knarfy.totallylegit.procedures;

import javax.annotation.Nullable;
import net.knarfy.totallylegit.init.TotallyLegitModGameRules;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

@EventBusSubscriber
public class FoodGivesEffectsProcedure {
    @SubscribeEvent
    public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
        if (event.getEntity() != null) {
            FoodGivesEffectsProcedure.execute((Event)event, (LevelAccessor)event.getEntity().level(), (Entity)event.getEntity(), event.getItem());
        }
    }

    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        FoodGivesEffectsProcedure.execute(null, world, entity, itemstack);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, ItemStack itemstack) {
        ServerLevel _serverLevelGR0;
        if (entity == null) {
            return;
        }
        if (world instanceof ServerLevel && (_serverLevelGR0 = (ServerLevel)world).getGameRules().getBoolean(TotallyLegitModGameRules.FOOD_IS_CRAZY) && itemstack.has(DataComponents.FOOD)) {
            LivingEntity _entity;
            if (entity instanceof LivingEntity && !(_entity = (LivingEntity)entity).level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3));
            }
            if (entity instanceof LivingEntity && !(_entity = (LivingEntity)entity).level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 1));
            }
            if (entity instanceof LivingEntity && !(_entity = (LivingEntity)entity).level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0));
            }
            if (entity instanceof LivingEntity && !(_entity = (LivingEntity)entity).level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0));
            }
        }
    }
}

