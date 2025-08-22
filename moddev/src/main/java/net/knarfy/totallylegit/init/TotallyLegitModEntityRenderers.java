/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.EntityType
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.neoforge.client.event.EntityRenderersEvent$RegisterRenderers
 */
package net.knarfy.totallylegit.init;

import net.knarfy.totallylegit.client.renderer.OneCycleBedProjectileRenderer;
import net.knarfy.totallylegit.client.renderer.SteveRenderer;
import net.knarfy.totallylegit.init.TotallyLegitModEntities;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD, value={Dist.CLIENT})
public class TotallyLegitModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType)TotallyLegitModEntities.ONE_CYCLE_BED_PROJECTILE.get(), OneCycleBedProjectileRenderer::new);
        event.registerEntityRenderer((EntityType)TotallyLegitModEntities.STEVE.get(), SteveRenderer::new);
    }
}

