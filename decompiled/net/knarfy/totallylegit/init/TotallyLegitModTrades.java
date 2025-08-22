/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.npc.VillagerProfession
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.common.BasicItemListing
 *  net.neoforged.neoforge.event.village.VillagerTradesEvent
 */
package net.knarfy.totallylegit.init;

import java.util.List;
import net.knarfy.totallylegit.init.TotallyLegitModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

@EventBusSubscriber
public class TotallyLegitModTrades {
    @SubscribeEvent
    public static void registerTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.CLERIC) {
            ((List)event.getTrades().get(1)).add(new BasicItemListing(new ItemStack((ItemLike)Items.ENDER_EYE), new ItemStack((ItemLike)TotallyLegitModItems.TOTEM_OF_COMPLETION.get()), 1, 10000, 0.05f));
        }
    }
}

