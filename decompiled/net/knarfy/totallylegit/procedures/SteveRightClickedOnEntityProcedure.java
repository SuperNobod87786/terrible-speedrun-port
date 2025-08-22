/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.ExperienceOrb
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 */
package net.knarfy.totallylegit.procedures;

import net.knarfy.totallylegit.TotallyLegitMod;
import net.knarfy.totallylegit.init.TotallyLegitModAttributes;
import net.knarfy.totallylegit.init.TotallyLegitModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class SteveRightClickedOnEntityProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
        ItemStack itemStack;
        if (entity == null || sourceentity == null) {
            return;
        }
        if (sourceentity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)sourceentity;
            itemStack = _livEnt.getMainHandItem();
        } else {
            itemStack = ItemStack.EMPTY;
        }
        if (itemStack.getItem() == Items.FLINT_AND_STEEL) {
            LivingEntity _livingEntity3;
            if (entity instanceof LivingEntity && (_livingEntity3 = (LivingEntity)entity).getAttributes().hasAttribute(TotallyLegitModAttributes.STEVE_ANIMATION_PLAY)) {
                LivingEntity _livingEntity2;
                _livingEntity3.getAttribute(TotallyLegitModAttributes.STEVE_ANIMATION_PLAY).setBaseValue((entity instanceof LivingEntity && (_livingEntity2 = (LivingEntity)entity).getAttributes().hasAttribute(TotallyLegitModAttributes.STEVE_ANIMATION_PLAY) ? _livingEntity2.getAttribute(TotallyLegitModAttributes.STEVE_ANIMATION_PLAY).getValue() : 0.0) + 1.0);
            }
            itemstack.shrink(1);
            if (sourceentity instanceof LivingEntity) {
                LivingEntity _entity = (LivingEntity)sourceentity;
                _entity.swing(InteractionHand.MAIN_HAND, true);
            }
            if (Mth.nextInt((RandomSource)RandomSource.create(), (int)1, (int)8) == 1 && world instanceof ServerLevel) {
                ServerLevel _level = (ServerLevel)world;
                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)Items.NAME_TAG));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity((Entity)entityToSpawn);
            }
            for (int index0 = 0; index0 < Mth.nextInt((RandomSource)RandomSource.create(), (int)15, (int)32); ++index0) {
                ServerLevel _level;
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    _level.addFreshEntity((Entity)new ExperienceOrb((Level)_level, x, y, z, 5));
                }
                if (!(world instanceof ServerLevel)) continue;
                _level = (ServerLevel)world;
                ItemEntity entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)TotallyLegitModItems.LAVA_CHICKEN.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity((Entity)entityToSpawn);
            }
            if (Mth.nextInt((RandomSource)RandomSource.create(), (int)1, (int)32) == 1) {
                if (!world.isClientSide() && world instanceof Level) {
                    Level _level = (Level)world;
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"totally_legit:chicken_jockey")), SoundSource.AMBIENT, 1.0f, 1.0f);
                    } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"totally_legit:chicken_jockey")), SoundSource.AMBIENT, 1.0f, 1.0f, false);
                    }
                }
            } else if (!world.isClientSide() && world instanceof Level) {
                Level _level = (Level)world;
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"totally_legit:lava_chicken")), SoundSource.AMBIENT, 1.0f, 1.0f);
                } else {
                    _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"totally_legit:lava_chicken")), SoundSource.AMBIENT, 1.0f, 1.0f, false);
                }
            }
            TotallyLegitMod.queueServerWork(17, () -> {
                LivingEntity _livingEntity18;
                if (entity instanceof LivingEntity && (_livingEntity18 = (LivingEntity)entity).getAttributes().hasAttribute(TotallyLegitModAttributes.STEVE_ANIMATION_PLAY)) {
                    LivingEntity _livingEntity17;
                    _livingEntity18.getAttribute(TotallyLegitModAttributes.STEVE_ANIMATION_PLAY).setBaseValue((entity instanceof LivingEntity && (_livingEntity17 = (LivingEntity)entity).getAttributes().hasAttribute(TotallyLegitModAttributes.STEVE_ANIMATION_PLAY) ? _livingEntity17.getAttribute(TotallyLegitModAttributes.STEVE_ANIMATION_PLAY).getValue() : 0.0) * 0.0);
                }
            });
        }
    }
}

