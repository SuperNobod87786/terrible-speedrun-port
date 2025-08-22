/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.neoforge.client.event.EntityRenderersEvent$RegisterLayerDefinitions
 */
package net.knarfy.totallylegit.init;

import net.knarfy.totallylegit.client.model.Modelbed_projectile;
import net.knarfy.totallylegit.client.model.Modelsteve;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD, value={Dist.CLIENT})
public class TotallyLegitModModels {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(Modelsteve.LAYER_LOCATION, Modelsteve::createBodyLayer);
        event.registerLayerDefinition(Modelbed_projectile.LAYER_LOCATION, Modelbed_projectile::createBodyLayer);
    }
}

