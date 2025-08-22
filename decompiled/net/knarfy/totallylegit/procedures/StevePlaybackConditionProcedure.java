/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 */
package net.knarfy.totallylegit.procedures;

import net.knarfy.totallylegit.init.TotallyLegitModAttributes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class StevePlaybackConditionProcedure {
    public static boolean execute(Entity entity) {
        LivingEntity _livingEntity0;
        if (entity == null) {
            return false;
        }
        return (entity instanceof LivingEntity && (_livingEntity0 = (LivingEntity)entity).getAttributes().hasAttribute(TotallyLegitModAttributes.STEVE_ANIMATION_PLAY) ? _livingEntity0.getAttribute(TotallyLegitModAttributes.STEVE_ANIMATION_PLAY).getValue() : 0.0) == 1.0;
    }
}

