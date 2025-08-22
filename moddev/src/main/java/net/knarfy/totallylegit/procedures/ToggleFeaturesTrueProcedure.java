/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.GameRules$BooleanValue
 *  net.minecraft.world.level.LevelAccessor
 */
package net.knarfy.totallylegit.procedures;

import net.knarfy.totallylegit.init.TotallyLegitModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;

public class ToggleFeaturesTrueProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        Player _player;
        ServerLevel _serverLevel;
        if (entity == null) {
            return;
        }
        if (world instanceof ServerLevel) {
            _serverLevel = (ServerLevel)world;
            ((GameRules.BooleanValue)_serverLevel.getGameRules().getRule(TotallyLegitModGameRules.FIFTY_FIFTY)).set(true, world.getServer());
        }
        if (world instanceof ServerLevel) {
            _serverLevel = (ServerLevel)world;
            ((GameRules.BooleanValue)_serverLevel.getGameRules().getRule(TotallyLegitModGameRules.CHICKENS_SCREAM)).set(true, world.getServer());
        }
        if (world instanceof ServerLevel) {
            _serverLevel = (ServerLevel)world;
            ((GameRules.BooleanValue)_serverLevel.getGameRules().getRule(TotallyLegitModGameRules.FOOD_IS_CRAZY)).set(true, world.getServer());
        }
        if (world instanceof ServerLevel) {
            _serverLevel = (ServerLevel)world;
            ((GameRules.BooleanValue)_serverLevel.getGameRules().getRule(TotallyLegitModGameRules.ENCHANTED_CRAFTING)).set(true, world.getServer());
        }
        if (world instanceof ServerLevel) {
            _serverLevel = (ServerLevel)world;
            ((GameRules.BooleanValue)_serverLevel.getGameRules().getRule(TotallyLegitModGameRules.SPAWN_STEVES)).set(true, world.getServer());
        }
        if (world instanceof ServerLevel) {
            _serverLevel = (ServerLevel)world;
            ((GameRules.BooleanValue)_serverLevel.getGameRules().getRule(TotallyLegitModGameRules.SPAWN_PORTALS)).set(true, world.getServer());
        }
        if (entity instanceof Player && !(_player = (Player)entity).level().isClientSide()) {
            _player.displayClientMessage((Component)Component.literal((String)"Features toggled on"), false);
        }
    }
}

