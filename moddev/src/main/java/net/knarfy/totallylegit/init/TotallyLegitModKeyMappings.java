/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.KeyMapping
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.world.entity.player.Player
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.neoforge.client.event.ClientTickEvent$Post
 *  net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent
 *  net.neoforged.neoforge.network.PacketDistributor
 */
package net.knarfy.totallylegit.init;

import net.knarfy.totallylegit.network.NKeyMessage;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD, value={Dist.CLIENT})
public class TotallyLegitModKeyMappings {
    public static final KeyMapping N_KEY = new KeyMapping("key.totally_legit.n_key", 78, "key.categories.misc"){
        private boolean isDownOld = false;

        public void setDown(boolean isDown) {
            super.setDown(isDown);
            if (this.isDownOld != isDown && isDown) {
                PacketDistributor.sendToServer((CustomPacketPayload)new NKeyMessage(0, 0), (CustomPacketPayload[])new CustomPacketPayload[0]);
                NKeyMessage.pressAction((Player)Minecraft.getInstance().player, 0, 0);
            }
            this.isDownOld = isDown;
        }
    };

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(N_KEY);
    }

    @EventBusSubscriber(value={Dist.CLIENT})
    public static class KeyEventListener {
        @SubscribeEvent
        public static void onClientTick(ClientTickEvent.Post event) {
            if (Minecraft.getInstance().screen == null) {
                N_KEY.consumeClick();
            }
        }
    }
}

