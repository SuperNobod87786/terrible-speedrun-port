/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.RegistryFriendlyByteBuf
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.network.protocol.PacketFlow
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload$Type
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 */
package net.knarfy.totallylegit.network;

import net.knarfy.totallylegit.TotallyLegitMod;
import net.knarfy.totallylegit.procedures.NKeyOnKeyPressedProcedure;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD)
public record NKeyMessage(int eventType, int pressedms) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<NKeyMessage> TYPE = new CustomPacketPayload.Type(ResourceLocation.fromNamespaceAndPath((String)"totally_legit", (String)"key_n_key"));
    public static final StreamCodec<RegistryFriendlyByteBuf, NKeyMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {
        buffer.writeInt(message.eventType);
        buffer.writeInt(message.pressedms);
    }, buffer -> new NKeyMessage(buffer.readInt(), buffer.readInt()));

    public CustomPacketPayload.Type<NKeyMessage> type() {
        return TYPE;
    }

    public static void handleData(NKeyMessage message, IPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> NKeyMessage.pressAction(context.player(), message.eventType, message.pressedms)).exceptionally(e -> {
                context.connection().disconnect((Component)Component.literal((String)e.getMessage()));
                return null;
            });
        }
    }

    public static void pressAction(Player entity, int type, int pressedms) {
        Level world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        if (!world.hasChunkAt(entity.blockPosition())) {
            return;
        }
        if (type == 0) {
            NKeyOnKeyPressedProcedure.execute((LevelAccessor)world, x, y, z);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        TotallyLegitMod.addNetworkMessage(TYPE, STREAM_CODEC, NKeyMessage::handleData);
    }
}

