/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EntityType$Builder
 *  net.minecraft.world.entity.MobCategory
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent
 *  net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package net.knarfy.totallylegit.init;

import net.knarfy.totallylegit.entity.OneCycleBedProjectileEntity;
import net.knarfy.totallylegit.entity.SteveEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD)
public class TotallyLegitModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create((ResourceKey)Registries.ENTITY_TYPE, (String)"totally_legit");
    public static final DeferredHolder<EntityType<?>, EntityType<OneCycleBedProjectileEntity>> ONE_CYCLE_BED_PROJECTILE = TotallyLegitModEntities.register("one_cycle_bed_projectile", EntityType.Builder.of(OneCycleBedProjectileEntity::new, (MobCategory)MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(1.5f, 0.5f));
    public static final DeferredHolder<EntityType<?>, EntityType<SteveEntity>> STEVE = TotallyLegitModEntities.register("steve", EntityType.Builder.of(SteveEntity::new, (MobCategory)MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(0.6f, 1.8f));

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> entityTypeBuilder.build(ResourceKey.create((ResourceKey)Registries.ENTITY_TYPE, (ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"totally_legit", (String)registryname))));
    }

    @SubscribeEvent
    public static void init(RegisterSpawnPlacementsEvent event) {
        SteveEntity.init(event);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put((EntityType)STEVE.get(), SteveEntity.createAttributes().build());
    }
}

