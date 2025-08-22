/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.ItemTags
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.enchantment.Enchantments
 *  net.minecraft.world.level.LevelAccessor
 *  net.neoforged.bus.api.Event
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.event.entity.player.PlayerEvent$ItemCraftedEvent
 */
package net.knarfy.totallylegit.procedures;

import javax.annotation.Nullable;
import net.knarfy.totallylegit.init.TotallyLegitModGameRules;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber
public class EnchantsOnCraftProcedure {
    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        EnchantsOnCraftProcedure.execute((Event)event, (LevelAccessor)event.getEntity().level(), event.getCrafting());
    }

    public static void execute(LevelAccessor world, ItemStack itemstack) {
        EnchantsOnCraftProcedure.execute(null, world, itemstack);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, ItemStack itemstack) {
        ServerLevel _serverLevelGR0;
        if (world instanceof ServerLevel && (_serverLevelGR0 = (ServerLevel)world).getGameRules().getBoolean(TotallyLegitModGameRules.ENCHANTED_CRAFTING)) {
            if (itemstack.is(ItemTags.create((ResourceLocation)ResourceLocation.parse((String)"minecraft:tools")))) {
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BANE_OF_ARTHROPODS), 10);
            } else if (itemstack.is(ItemTags.create((ResourceLocation)ResourceLocation.parse((String)"minecraft:armor")))) {
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BLAST_PROTECTION), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROJECTILE_PROTECTION), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.THORNS), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FROST_WALKER), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWIFT_SNEAK), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SOUL_SPEED), 10);
            } else if (itemstack.is(ItemTags.create((ResourceLocation)ResourceLocation.parse((String)"minecraft:ranged")))) {
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FLAME), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.QUICK_CHARGE), 10);
                itemstack.enchant((Holder)world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PUNCH), 10);
            }
        }
    }
}

