/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Rarity
 *  net.minecraft.world.item.context.UseOnContext
 *  net.minecraft.world.level.LevelAccessor
 */
package net.knarfy.totallylegit.item;

import net.knarfy.totallylegit.procedures.SubscribeButtonRightclickedOnBlockProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelAccessor;

public class SubscribeButtonItem
extends Item {
    public SubscribeButtonItem(Item.Properties properties) {
        super(properties.rarity(Rarity.COMMON).stacksTo(1));
    }

    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        SubscribeButtonRightclickedOnBlockProcedure.execute((LevelAccessor)context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ());
        return InteractionResult.SUCCESS;
    }
}

