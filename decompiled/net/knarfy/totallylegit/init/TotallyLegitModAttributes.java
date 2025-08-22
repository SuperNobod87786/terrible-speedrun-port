/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.ai.attributes.Attribute
 *  net.minecraft.world.entity.ai.attributes.DefaultAttributes
 *  net.minecraft.world.entity.ai.attributes.RangedAttribute
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package net.knarfy.totallylegit.init;

import java.util.List;
import java.util.stream.Collectors;
import net.knarfy.totallylegit.init.TotallyLegitModEntities;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD)
public class TotallyLegitModAttributes {
    public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create((Registry)BuiltInRegistries.ATTRIBUTE, (String)"totally_legit");
    public static final DeferredHolder<Attribute, Attribute> STEVE_ANIMATION_PLAY = REGISTRY.register("steve_animation_play", () -> new RangedAttribute("attribute.totally_legit.steve_animation_play", 0.0, 0.0, 1.0).setSyncable(true));

    @SubscribeEvent
    public static void addAttributes(EntityAttributeModificationEvent event) {
        List.of((EntityType)TotallyLegitModEntities.STEVE.get()).stream().filter(DefaultAttributes::hasSupplier).map(entityType -> entityType).collect(Collectors.toList()).forEach(entity -> event.add(entity, STEVE_ANIMATION_PLAY));
    }
}

