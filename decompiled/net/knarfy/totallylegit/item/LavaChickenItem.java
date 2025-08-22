/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.food.FoodProperties$Builder
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Rarity
 *  net.minecraft.world.level.Level
 */
package net.knarfy.totallylegit.item;

import net.knarfy.totallylegit.procedures.LavaChickenPlayerFinishesUsingItemProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class LavaChickenItem
extends Item {
    public LavaChickenItem(Item.Properties properties) {
        super(properties.rarity(Rarity.RARE).stacksTo(64).food(new FoodProperties.Builder().nutrition(6).saturationModifier(8.0f).alwaysEdible().build()));
    }

    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        LavaChickenPlayerFinishesUsingItemProcedure.execute((Entity)entity);
        return retval;
    }
}

