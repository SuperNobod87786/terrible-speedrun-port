/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package net.knarfy.totallylegit.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TotallyLegitModSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create((ResourceKey)Registries.SOUND_EVENT, (String)"totally_legit");
    public static final DeferredHolder<SoundEvent, SoundEvent> SCREAMING = REGISTRY.register("screaming", () -> SoundEvent.createVariableRangeEvent((ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"totally_legit", (String)"screaming")));
    public static final DeferredHolder<SoundEvent, SoundEvent> I_AM_STEVE = REGISTRY.register("i_am_steve", () -> SoundEvent.createVariableRangeEvent((ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"totally_legit", (String)"i_am_steve")));
    public static final DeferredHolder<SoundEvent, SoundEvent> LAVA_CHICKEN = REGISTRY.register("lava_chicken", () -> SoundEvent.createVariableRangeEvent((ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"totally_legit", (String)"lava_chicken")));
    public static final DeferredHolder<SoundEvent, SoundEvent> CHICKEN_JOCKEY = REGISTRY.register("chicken_jockey", () -> SoundEvent.createVariableRangeEvent((ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"totally_legit", (String)"chicken_jockey")));
}

