/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectCategory
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.level.LevelAccessor
 */
package net.knarfy.totallylegit.potion;

import net.knarfy.totallylegit.procedures.LavaChickendOnEffectActiveTickProcedure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class LavaChickendMobEffect
extends MobEffect {
    public LavaChickendMobEffect() {
        super(MobEffectCategory.NEUTRAL, -35072);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath((String)"totally_legit", (String)"effect.lava_chickend_0"), 0.8, AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.STEP_HEIGHT, ResourceLocation.fromNamespaceAndPath((String)"totally_legit", (String)"effect.lava_chickend_1"), 3.0, AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.JUMP_STRENGTH, ResourceLocation.fromNamespaceAndPath((String)"totally_legit", (String)"effect.lava_chickend_2"), 0.7, AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.FALL_DAMAGE_MULTIPLIER, ResourceLocation.fromNamespaceAndPath((String)"totally_legit", (String)"effect.lava_chickend_3"), -3.0, AttributeModifier.Operation.ADD_VALUE);
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        LavaChickendOnEffectActiveTickProcedure.execute((LevelAccessor)level, entity.getX(), entity.getY(), entity.getZ(), (Entity)entity);
        return super.applyEffectTick(level, entity, amplifier);
    }
}

