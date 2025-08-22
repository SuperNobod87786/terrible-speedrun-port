/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.GameRules$BooleanValue
 *  net.minecraft.world.level.GameRules$Category
 *  net.minecraft.world.level.GameRules$Key
 *  net.minecraft.world.level.GameRules$Type
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
 */
package net.knarfy.totallylegit.init;

import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD)
public class TotallyLegitModGameRules {
    public static GameRules.Key<GameRules.BooleanValue> FIFTY_FIFTY;
    public static GameRules.Key<GameRules.BooleanValue> CHICKENS_SCREAM;
    public static GameRules.Key<GameRules.BooleanValue> FOOD_IS_CRAZY;
    public static GameRules.Key<GameRules.BooleanValue> ENCHANTED_CRAFTING;
    public static GameRules.Key<GameRules.BooleanValue> SPAWN_STEVES;
    public static GameRules.Key<GameRules.BooleanValue> SPAWN_PORTALS;

    @SubscribeEvent
    public static void registerGameRules(FMLCommonSetupEvent event) {
        FIFTY_FIFTY = GameRules.register((String)"fiftyFifty", (GameRules.Category)GameRules.Category.MOBS, (GameRules.Type)GameRules.BooleanValue.create((boolean)true));
        CHICKENS_SCREAM = GameRules.register((String)"chickensScream", (GameRules.Category)GameRules.Category.MOBS, (GameRules.Type)GameRules.BooleanValue.create((boolean)true));
        FOOD_IS_CRAZY = GameRules.register((String)"foodIsCrazy", (GameRules.Category)GameRules.Category.MISC, (GameRules.Type)GameRules.BooleanValue.create((boolean)true));
        ENCHANTED_CRAFTING = GameRules.register((String)"enchantedCrafting", (GameRules.Category)GameRules.Category.MISC, (GameRules.Type)GameRules.BooleanValue.create((boolean)true));
        SPAWN_STEVES = GameRules.register((String)"spawnSteves", (GameRules.Category)GameRules.Category.MOBS, (GameRules.Type)GameRules.BooleanValue.create((boolean)true));
        SPAWN_PORTALS = GameRules.register((String)"spawnPortals", (GameRules.Category)GameRules.Category.PLAYER, (GameRules.Type)GameRules.BooleanValue.create((boolean)true));
    }
}

