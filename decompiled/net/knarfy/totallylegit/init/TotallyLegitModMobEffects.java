/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.effect.MobEffect
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package net.knarfy.totallylegit.init;

import net.knarfy.totallylegit.potion.LavaChickendMobEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TotallyLegitModMobEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create((ResourceKey)Registries.MOB_EFFECT, (String)"totally_legit");
    public static final DeferredHolder<MobEffect, MobEffect> LAVA_CHICKEND = REGISTRY.register("lava_chickend", () -> new LavaChickendMobEffect());
}

