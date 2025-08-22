/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.ItemUseAnimation
 *  net.minecraft.world.item.Rarity
 *  net.minecraft.world.level.Level
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package net.knarfy.totallylegit.item;

import net.knarfy.totallylegit.procedures.OneCycleBedPlayerFinishesUsingItemProcedure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class OneCycleBedItem
extends Item {
    public OneCycleBedItem(Item.Properties properties) {
        super(properties.rarity(Rarity.EPIC).stacksTo(1).fireResistant());
    }

    public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
        return ItemUseAnimation.BOW;
    }

    public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
        return 72000;
    }

    @OnlyIn(value=Dist.CLIENT)
    public boolean isFoil(ItemStack itemstack) {
        return true;
    }

    public InteractionResult use(Level world, Player entity, InteractionHand hand) {
        InteractionResult ar = super.use(world, entity, hand);
        entity.startUsingItem(hand);
        return ar;
    }

    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        OneCycleBedPlayerFinishesUsingItemProcedure.execute((Entity)entity);
        return retval;
    }

    public boolean releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
        OneCycleBedPlayerFinishesUsingItemProcedure.execute((Entity)entity);
        return super.releaseUsing(itemstack, world, entity, time);
    }
}

