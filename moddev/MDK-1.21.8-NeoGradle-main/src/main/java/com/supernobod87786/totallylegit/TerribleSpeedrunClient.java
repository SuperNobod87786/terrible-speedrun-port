package com.supernobod87786.totallylegit;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = TerribleSpeedrun.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = TerribleSpeedrun.MODID, value = Dist.CLIENT)
public class TerribleSpeedrunClient {
    public TerribleSpeedrunClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        TerribleSpeedrun.LOGGER.info("HELLO FROM CLIENT SETUP");
        TerribleSpeedrun.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
}