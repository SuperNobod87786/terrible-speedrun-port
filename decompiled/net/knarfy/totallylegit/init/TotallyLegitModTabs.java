/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.item.CreativeModeTab
 *  net.minecraft.world.item.CreativeModeTabs
 *  net.minecraft.world.level.ItemLike
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package net.knarfy.totallylegit.init;

import net.knarfy.totallylegit.init.TotallyLegitModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD)
public class TotallyLegitModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create((ResourceKey)Registries.CREATIVE_MODE_TAB, (String)"totally_legit");

    @SubscribeEvent
    public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
        if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            tabData.accept((ItemLike)TotallyLegitModItems.MAGICAL_PICKLE.get());
            tabData.accept((ItemLike)TotallyLegitModItems.LAVA_CHICKEN.get());
        } else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            tabData.accept((ItemLike)TotallyLegitModItems.SUBSCRIBE_BUTTON.get());
        } else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            tabData.accept((ItemLike)TotallyLegitModItems.TOTEM_OF_COMPLETION.get());
            tabData.accept((ItemLike)TotallyLegitModItems.ONE_CYCLE_BED.get());
        } else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            tabData.accept((ItemLike)TotallyLegitModItems.STEVE_SPAWN_EGG.get());
        }
    }
}

