/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload$Type
 *  net.minecraft.util.Tuple
 *  net.neoforged.bus.api.IEventBus
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.Mod
 *  net.neoforged.fml.util.thread.SidedThreadGroups
 *  net.neoforged.neoforge.common.NeoForge
 *  net.neoforged.neoforge.event.tick.ServerTickEvent$Post
 *  net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent
 *  net.neoforged.neoforge.network.handling.IPayloadHandler
 *  net.neoforged.neoforge.network.registration.PayloadRegistrar
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package net.knarfy.totallylegit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.knarfy.totallylegit.init.TotallyLegitModAttributes;
import net.knarfy.totallylegit.init.TotallyLegitModEntities;
import net.knarfy.totallylegit.init.TotallyLegitModItems;
import net.knarfy.totallylegit.init.TotallyLegitModMobEffects;
import net.knarfy.totallylegit.init.TotallyLegitModSounds;
import net.knarfy.totallylegit.init.TotallyLegitModTabs;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.util.Tuple;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value="totally_legit")
public class TotallyLegitMod {
    public static final Logger LOGGER = LogManager.getLogger(TotallyLegitMod.class);
    public static final String MODID = "totally_legit";
    private static boolean networkingRegistered = false;
    private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap();
    private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<Tuple<Runnable, Integer>>();

    public TotallyLegitMod(IEventBus modEventBus) {
        NeoForge.EVENT_BUS.register((Object)this);
        modEventBus.addListener(this::registerNetworking);
        TotallyLegitModSounds.REGISTRY.register(modEventBus);
        TotallyLegitModItems.REGISTRY.register(modEventBus);
        TotallyLegitModEntities.REGISTRY.register(modEventBus);
        TotallyLegitModTabs.REGISTRY.register(modEventBus);
        TotallyLegitModMobEffects.REGISTRY.register(modEventBus);
        TotallyLegitModAttributes.REGISTRY.register(modEventBus);
    }

    public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
        if (networkingRegistered) {
            throw new IllegalStateException("Cannot register new network messages after networking has been registered");
        }
        MESSAGES.put(id, new NetworkMessage<T>(reader, handler));
    }

    private void registerNetworking(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(MODID);
        MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, networkMessage.reader(), networkMessage.handler()));
        networkingRegistered = true;
    }

    public static void queueServerWork(int tick, Runnable action) {
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
            workQueue.add((Tuple<Runnable, Integer>)new Tuple((Object)action, (Object)tick));
        }
    }

    @SubscribeEvent
    public void tick(ServerTickEvent.Post event) {
        ArrayList actions = new ArrayList();
        workQueue.forEach(work -> {
            work.setB((Object)((Integer)work.getB() - 1));
            if ((Integer)work.getB() == 0) {
                actions.add(work);
            }
        });
        actions.forEach(e -> ((Runnable)e.getA()).run());
        workQueue.removeAll(actions);
    }

    private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
    }
}

