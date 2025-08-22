/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.SpawnEggItem
 *  net.neoforged.neoforge.registries.DeferredItem
 *  net.neoforged.neoforge.registries.DeferredRegister
 *  net.neoforged.neoforge.registries.DeferredRegister$Items
 */
package net.knarfy.totallylegit.init;

import java.util.function.Function;
import net.knarfy.totallylegit.init.TotallyLegitModEntities;
import net.knarfy.totallylegit.item.LavaChickenItem;
import net.knarfy.totallylegit.item.MagicalPickleItem;
import net.knarfy.totallylegit.item.OneCycleBedItem;
import net.knarfy.totallylegit.item.SubscribeButtonItem;
import net.knarfy.totallylegit.item.TotemOfCompletionItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TotallyLegitModItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems((String)"totally_legit");
    public static final DeferredItem<Item> MAGICAL_PICKLE = TotallyLegitModItems.register("magical_pickle", MagicalPickleItem::new);
    public static final DeferredItem<Item> SUBSCRIBE_BUTTON = TotallyLegitModItems.register("subscribe_button", SubscribeButtonItem::new);
    public static final DeferredItem<Item> TOTEM_OF_COMPLETION = TotallyLegitModItems.register("totem_of_completion", TotemOfCompletionItem::new);
    public static final DeferredItem<Item> ONE_CYCLE_BED = TotallyLegitModItems.register("one_cycle_bed", OneCycleBedItem::new);
    public static final DeferredItem<Item> LAVA_CHICKEN = TotallyLegitModItems.register("lava_chicken", LavaChickenItem::new);
    public static final DeferredItem<Item> STEVE_SPAWN_EGG = TotallyLegitModItems.register("steve_spawn_egg", properties -> new SpawnEggItem((EntityType)TotallyLegitModEntities.STEVE.get(), properties));

    private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
        return REGISTRY.registerItem(name, supplier, new Item.Properties());
    }
}

