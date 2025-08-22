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
 *  net.minecraft.world.level.LevelAccessor
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package net.knarfy.totallylegit.item;

import net.knarfy.totallylegit.procedures.TotemOfCompletionPlayerFinishesUsingItemProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class TotemOfCompletionItem
extends Item {
    public TotemOfCompletionItem(Item.Properties properties) {
        super(properties.rarity(Rarity.EPIC).stacksTo(1).fireResistant().food(new FoodProperties.Builder().nutrition(0).saturationModifier(0.0f).alwaysEdible().build()));
    }

    @OnlyIn(value=Dist.CLIENT)
    public boolean isFoil(ItemStack itemstack) {
        return true;
    }

    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        TotemOfCompletionPlayerFinishesUsingItemProcedure.execute((LevelAccessor)world, x, y, z, (Entity)entity);
        return retval;
    }
}

