/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.commands.CommandSource
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySpawnReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LightningBolt
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec2
 *  net.minecraft.world.phys.Vec3
 */
package net.knarfy.totallylegit.procedures;

import net.knarfy.totallylegit.TotallyLegitMod;
import net.knarfy.totallylegit.init.TotallyLegitModGameRules;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class MagicalPickleTransportationProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        ServerLevel _serverLevelGR0;
        if (world instanceof ServerLevel && (_serverLevelGR0 = (ServerLevel)world).getGameRules().getBoolean(TotallyLegitModGameRules.SPAWN_PORTALS)) {
            EnumProperty _dp;
            world.levelEvent(2001, BlockPos.containing((double)(x - 1.0), (double)y, (double)(z + 2.0)), Block.getId((BlockState)Blocks.END_PORTAL_FRAME.defaultBlockState()));
            world.setBlock(BlockPos.containing((double)(x - 1.0), (double)y, (double)(z + 2.0)), Blocks.END_PORTAL_FRAME.defaultBlockState(), 3);
            Direction _dir = Direction.NORTH;
            BlockPos _pos = BlockPos.containing((double)(x - 1.0), (double)y, (double)(z + 2.0));
            BlockState _bs = world.getBlockState(_pos);
            Property property = _bs.getBlock().getStateDefinition().getProperty("facing");
            if (property instanceof EnumProperty && (_dp = (EnumProperty)property).getPossibleValues().contains(_dir)) {
                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_dp, (Comparable)_dir), 3);
            } else {
                EnumProperty _ap;
                property = _bs.getBlock().getStateDefinition().getProperty("axis");
                if (property instanceof EnumProperty && (_ap = (EnumProperty)property).getPossibleValues().contains(_dir.getAxis())) {
                    world.setBlock(_pos, (BlockState)_bs.setValue((Property)_ap, (Comparable)_dir.getAxis()), 3);
                }
            }
            TotallyLegitMod.queueServerWork(2, () -> {
                EnumProperty _dp;
                world.levelEvent(2001, BlockPos.containing((double)x, (double)y, (double)(z + 2.0)), Block.getId((BlockState)Blocks.END_PORTAL_FRAME.defaultBlockState()));
                world.setBlock(BlockPos.containing((double)x, (double)y, (double)(z + 2.0)), Blocks.END_PORTAL_FRAME.defaultBlockState(), 3);
                Direction _dir = Direction.NORTH;
                BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)(z + 2.0));
                BlockState _bs = world.getBlockState(_pos);
                Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("facing");
                if (patt0$temp instanceof EnumProperty && (_dp = (EnumProperty)patt0$temp).getPossibleValues().contains(_dir)) {
                    world.setBlock(_pos, (BlockState)_bs.setValue((Property)_dp, (Comparable)_dir), 3);
                } else {
                    EnumProperty _ap;
                    Property patt1$temp = _bs.getBlock().getStateDefinition().getProperty("axis");
                    if (patt1$temp instanceof EnumProperty && (_ap = (EnumProperty)patt1$temp).getPossibleValues().contains(_dir.getAxis())) {
                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_ap, (Comparable)_dir.getAxis()), 3);
                    }
                }
                TotallyLegitMod.queueServerWork(2, () -> {
                    EnumProperty _dp;
                    world.levelEvent(2001, BlockPos.containing((double)(x + 1.0), (double)y, (double)(z + 2.0)), Block.getId((BlockState)Blocks.END_PORTAL_FRAME.defaultBlockState()));
                    world.setBlock(BlockPos.containing((double)(x + 1.0), (double)y, (double)(z + 2.0)), Blocks.END_PORTAL_FRAME.defaultBlockState(), 3);
                    Direction _dir = Direction.NORTH;
                    BlockPos _pos = BlockPos.containing((double)(x + 1.0), (double)y, (double)(z + 2.0));
                    BlockState _bs = world.getBlockState(_pos);
                    Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (patt0$temp instanceof EnumProperty && (_dp = (EnumProperty)patt0$temp).getPossibleValues().contains(_dir)) {
                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_dp, (Comparable)_dir), 3);
                    } else {
                        EnumProperty _ap;
                        Property patt1$temp = _bs.getBlock().getStateDefinition().getProperty("axis");
                        if (patt1$temp instanceof EnumProperty && (_ap = (EnumProperty)patt1$temp).getPossibleValues().contains(_dir.getAxis())) {
                            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_ap, (Comparable)_dir.getAxis()), 3);
                        }
                    }
                    TotallyLegitMod.queueServerWork(2, () -> {
                        EnumProperty _dp;
                        world.levelEvent(2001, BlockPos.containing((double)(x + 2.0), (double)y, (double)(z + 1.0)), Block.getId((BlockState)Blocks.END_PORTAL_FRAME.defaultBlockState()));
                        world.setBlock(BlockPos.containing((double)(x + 2.0), (double)y, (double)(z + 1.0)), Blocks.END_PORTAL_FRAME.defaultBlockState(), 3);
                        Direction _dir = Direction.WEST;
                        BlockPos _pos = BlockPos.containing((double)(x + 2.0), (double)y, (double)(z + 1.0));
                        BlockState _bs = world.getBlockState(_pos);
                        Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("facing");
                        if (patt0$temp instanceof EnumProperty && (_dp = (EnumProperty)patt0$temp).getPossibleValues().contains(_dir)) {
                            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_dp, (Comparable)_dir), 3);
                        } else {
                            EnumProperty _ap;
                            Property patt1$temp = _bs.getBlock().getStateDefinition().getProperty("axis");
                            if (patt1$temp instanceof EnumProperty && (_ap = (EnumProperty)patt1$temp).getPossibleValues().contains(_dir.getAxis())) {
                                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_ap, (Comparable)_dir.getAxis()), 3);
                            }
                        }
                        TotallyLegitMod.queueServerWork(2, () -> {
                            EnumProperty _dp;
                            world.levelEvent(2001, BlockPos.containing((double)(x + 2.0), (double)y, (double)(z + 0.0)), Block.getId((BlockState)Blocks.END_PORTAL_FRAME.defaultBlockState()));
                            world.setBlock(BlockPos.containing((double)(x + 2.0), (double)y, (double)(z + 0.0)), Blocks.END_PORTAL_FRAME.defaultBlockState(), 3);
                            Direction _dir = Direction.WEST;
                            BlockPos _pos = BlockPos.containing((double)(x + 2.0), (double)y, (double)(z + 0.0));
                            BlockState _bs = world.getBlockState(_pos);
                            Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("facing");
                            if (patt0$temp instanceof EnumProperty && (_dp = (EnumProperty)patt0$temp).getPossibleValues().contains(_dir)) {
                                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_dp, (Comparable)_dir), 3);
                            } else {
                                EnumProperty _ap;
                                Property patt1$temp = _bs.getBlock().getStateDefinition().getProperty("axis");
                                if (patt1$temp instanceof EnumProperty && (_ap = (EnumProperty)patt1$temp).getPossibleValues().contains(_dir.getAxis())) {
                                    world.setBlock(_pos, (BlockState)_bs.setValue((Property)_ap, (Comparable)_dir.getAxis()), 3);
                                }
                            }
                            TotallyLegitMod.queueServerWork(2, () -> {
                                EnumProperty _dp;
                                world.levelEvent(2001, BlockPos.containing((double)(x + 2.0), (double)y, (double)(z - 1.0)), Block.getId((BlockState)Blocks.END_PORTAL_FRAME.defaultBlockState()));
                                world.setBlock(BlockPos.containing((double)(x + 2.0), (double)y, (double)(z - 1.0)), Blocks.END_PORTAL_FRAME.defaultBlockState(), 3);
                                Direction _dir = Direction.WEST;
                                BlockPos _pos = BlockPos.containing((double)(x + 2.0), (double)y, (double)(z - 1.0));
                                BlockState _bs = world.getBlockState(_pos);
                                Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (patt0$temp instanceof EnumProperty && (_dp = (EnumProperty)patt0$temp).getPossibleValues().contains(_dir)) {
                                    world.setBlock(_pos, (BlockState)_bs.setValue((Property)_dp, (Comparable)_dir), 3);
                                } else {
                                    EnumProperty _ap;
                                    Property patt1$temp = _bs.getBlock().getStateDefinition().getProperty("axis");
                                    if (patt1$temp instanceof EnumProperty && (_ap = (EnumProperty)patt1$temp).getPossibleValues().contains(_dir.getAxis())) {
                                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_ap, (Comparable)_dir.getAxis()), 3);
                                    }
                                }
                                TotallyLegitMod.queueServerWork(2, () -> {
                                    EnumProperty _dp;
                                    world.levelEvent(2001, BlockPos.containing((double)(x + 1.0), (double)y, (double)(z - 2.0)), Block.getId((BlockState)Blocks.END_PORTAL_FRAME.defaultBlockState()));
                                    world.setBlock(BlockPos.containing((double)(x + 1.0), (double)y, (double)(z - 2.0)), Blocks.END_PORTAL_FRAME.defaultBlockState(), 3);
                                    Direction _dir = Direction.SOUTH;
                                    BlockPos _pos = BlockPos.containing((double)(x + 1.0), (double)y, (double)(z - 2.0));
                                    BlockState _bs = world.getBlockState(_pos);
                                    Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("facing");
                                    if (patt0$temp instanceof EnumProperty && (_dp = (EnumProperty)patt0$temp).getPossibleValues().contains(_dir)) {
                                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_dp, (Comparable)_dir), 3);
                                    } else {
                                        EnumProperty _ap;
                                        Property patt1$temp = _bs.getBlock().getStateDefinition().getProperty("axis");
                                        if (patt1$temp instanceof EnumProperty && (_ap = (EnumProperty)patt1$temp).getPossibleValues().contains(_dir.getAxis())) {
                                            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_ap, (Comparable)_dir.getAxis()), 3);
                                        }
                                    }
                                    TotallyLegitMod.queueServerWork(2, () -> {
                                        EnumProperty _dp;
                                        world.levelEvent(2001, BlockPos.containing((double)(x + 0.0), (double)y, (double)(z - 2.0)), Block.getId((BlockState)Blocks.END_PORTAL_FRAME.defaultBlockState()));
                                        world.setBlock(BlockPos.containing((double)(x + 0.0), (double)y, (double)(z - 2.0)), Blocks.END_PORTAL_FRAME.defaultBlockState(), 3);
                                        Direction _dir = Direction.SOUTH;
                                        BlockPos _pos = BlockPos.containing((double)(x + 0.0), (double)y, (double)(z - 2.0));
                                        BlockState _bs = world.getBlockState(_pos);
                                        Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("facing");
                                        if (patt0$temp instanceof EnumProperty && (_dp = (EnumProperty)patt0$temp).getPossibleValues().contains(_dir)) {
                                            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_dp, (Comparable)_dir), 3);
                                        } else {
                                            EnumProperty _ap;
                                            Property patt1$temp = _bs.getBlock().getStateDefinition().getProperty("axis");
                                            if (patt1$temp instanceof EnumProperty && (_ap = (EnumProperty)patt1$temp).getPossibleValues().contains(_dir.getAxis())) {
                                                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_ap, (Comparable)_dir.getAxis()), 3);
                                            }
                                        }
                                        TotallyLegitMod.queueServerWork(2, () -> {
                                            EnumProperty _dp;
                                            world.levelEvent(2001, BlockPos.containing((double)(x - 1.0), (double)y, (double)(z - 2.0)), Block.getId((BlockState)Blocks.END_PORTAL_FRAME.defaultBlockState()));
                                            world.setBlock(BlockPos.containing((double)(x - 1.0), (double)y, (double)(z - 2.0)), Blocks.END_PORTAL_FRAME.defaultBlockState(), 3);
                                            Direction _dir = Direction.SOUTH;
                                            BlockPos _pos = BlockPos.containing((double)(x - 1.0), (double)y, (double)(z - 2.0));
                                            BlockState _bs = world.getBlockState(_pos);
                                            Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("facing");
                                            if (patt0$temp instanceof EnumProperty && (_dp = (EnumProperty)patt0$temp).getPossibleValues().contains(_dir)) {
                                                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_dp, (Comparable)_dir), 3);
                                            } else {
                                                EnumProperty _ap;
                                                Property patt1$temp = _bs.getBlock().getStateDefinition().getProperty("axis");
                                                if (patt1$temp instanceof EnumProperty && (_ap = (EnumProperty)patt1$temp).getPossibleValues().contains(_dir.getAxis())) {
                                                    world.setBlock(_pos, (BlockState)_bs.setValue((Property)_ap, (Comparable)_dir.getAxis()), 3);
                                                }
                                            }
                                            TotallyLegitMod.queueServerWork(2, () -> {
                                                EnumProperty _dp;
                                                world.levelEvent(2001, BlockPos.containing((double)(x - 2.0), (double)y, (double)(z - 1.0)), Block.getId((BlockState)Blocks.END_PORTAL_FRAME.defaultBlockState()));
                                                world.setBlock(BlockPos.containing((double)(x - 2.0), (double)y, (double)(z - 1.0)), Blocks.END_PORTAL_FRAME.defaultBlockState(), 3);
                                                Direction _dir = Direction.EAST;
                                                BlockPos _pos = BlockPos.containing((double)(x - 2.0), (double)y, (double)(z - 1.0));
                                                BlockState _bs = world.getBlockState(_pos);
                                                Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("facing");
                                                if (patt0$temp instanceof EnumProperty && (_dp = (EnumProperty)patt0$temp).getPossibleValues().contains(_dir)) {
                                                    world.setBlock(_pos, (BlockState)_bs.setValue((Property)_dp, (Comparable)_dir), 3);
                                                } else {
                                                    EnumProperty _ap;
                                                    Property patt1$temp = _bs.getBlock().getStateDefinition().getProperty("axis");
                                                    if (patt1$temp instanceof EnumProperty && (_ap = (EnumProperty)patt1$temp).getPossibleValues().contains(_dir.getAxis())) {
                                                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_ap, (Comparable)_dir.getAxis()), 3);
                                                    }
                                                }
                                                TotallyLegitMod.queueServerWork(2, () -> {
                                                    EnumProperty _dp;
                                                    world.levelEvent(2001, BlockPos.containing((double)(x - 2.0), (double)y, (double)(z - 0.0)), Block.getId((BlockState)Blocks.END_PORTAL_FRAME.defaultBlockState()));
                                                    world.setBlock(BlockPos.containing((double)(x - 2.0), (double)y, (double)(z - 0.0)), Blocks.END_PORTAL_FRAME.defaultBlockState(), 3);
                                                    Direction _dir = Direction.EAST;
                                                    BlockPos _pos = BlockPos.containing((double)(x - 2.0), (double)y, (double)(z - 0.0));
                                                    BlockState _bs = world.getBlockState(_pos);
                                                    Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("facing");
                                                    if (patt0$temp instanceof EnumProperty && (_dp = (EnumProperty)patt0$temp).getPossibleValues().contains(_dir)) {
                                                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_dp, (Comparable)_dir), 3);
                                                    } else {
                                                        EnumProperty _ap;
                                                        Property patt1$temp = _bs.getBlock().getStateDefinition().getProperty("axis");
                                                        if (patt1$temp instanceof EnumProperty && (_ap = (EnumProperty)patt1$temp).getPossibleValues().contains(_dir.getAxis())) {
                                                            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_ap, (Comparable)_dir.getAxis()), 3);
                                                        }
                                                    }
                                                    TotallyLegitMod.queueServerWork(2, () -> {
                                                        EnumProperty _dp;
                                                        world.levelEvent(2001, BlockPos.containing((double)(x - 2.0), (double)y, (double)(z + 1.0)), Block.getId((BlockState)Blocks.END_PORTAL_FRAME.defaultBlockState()));
                                                        world.setBlock(BlockPos.containing((double)(x - 2.0), (double)y, (double)(z + 1.0)), Blocks.END_PORTAL_FRAME.defaultBlockState(), 3);
                                                        Direction _dir = Direction.EAST;
                                                        BlockPos _pos = BlockPos.containing((double)(x - 2.0), (double)y, (double)(z + 1.0));
                                                        BlockState _bs = world.getBlockState(_pos);
                                                        Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("facing");
                                                        if (patt0$temp instanceof EnumProperty && (_dp = (EnumProperty)patt0$temp).getPossibleValues().contains(_dir)) {
                                                            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_dp, (Comparable)_dir), 3);
                                                        } else {
                                                            EnumProperty _ap;
                                                            Property patt1$temp = _bs.getBlock().getStateDefinition().getProperty("axis");
                                                            if (patt1$temp instanceof EnumProperty && (_ap = (EnumProperty)patt1$temp).getPossibleValues().contains(_dir.getAxis())) {
                                                                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_ap, (Comparable)_dir.getAxis()), 3);
                                                            }
                                                        }
                                                        TotallyLegitMod.queueServerWork(2, () -> {
                                                            BlockPos _pos = BlockPos.containing((double)(x - 1.0), (double)y, (double)(z + 2.0));
                                                            BlockState _bs = world.getBlockState(_pos);
                                                            Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("eye");
                                                            if (patt0$temp instanceof BooleanProperty) {
                                                                BooleanProperty _booleanProp = (BooleanProperty)patt0$temp;
                                                                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_booleanProp, (Comparable)Boolean.valueOf(true)), 3);
                                                            }
                                                            if (world instanceof Level) {
                                                                Level _level = (Level)world;
                                                                if (!_level.isClientSide()) {
                                                                    _level.playSound(null, BlockPos.containing((double)(x - 1.0), (double)y, (double)(z + 2.0)), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 0.7f);
                                                                } else {
                                                                    _level.playLocalSound(x - 1.0, y, z + 2.0, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 0.7f, false);
                                                                }
                                                            }
                                                            TotallyLegitMod.queueServerWork(1, () -> {
                                                                BlockPos _pos = BlockPos.containing((double)(x - 0.0), (double)y, (double)(z + 2.0));
                                                                BlockState _bs = world.getBlockState(_pos);
                                                                Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("eye");
                                                                if (patt0$temp instanceof BooleanProperty) {
                                                                    BooleanProperty _booleanProp = (BooleanProperty)patt0$temp;
                                                                    world.setBlock(_pos, (BlockState)_bs.setValue((Property)_booleanProp, (Comparable)Boolean.valueOf(true)), 3);
                                                                }
                                                                if (world instanceof Level) {
                                                                    Level _level = (Level)world;
                                                                    if (!_level.isClientSide()) {
                                                                        _level.playSound(null, BlockPos.containing((double)(x - 0.0), (double)y, (double)(z + 2.0)), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 0.8f);
                                                                    } else {
                                                                        _level.playLocalSound(x - 0.0, y, z + 2.0, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 0.8f, false);
                                                                    }
                                                                }
                                                                TotallyLegitMod.queueServerWork(1, () -> {
                                                                    BlockPos _pos = BlockPos.containing((double)(x + 1.0), (double)y, (double)(z + 2.0));
                                                                    BlockState _bs = world.getBlockState(_pos);
                                                                    Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("eye");
                                                                    if (patt0$temp instanceof BooleanProperty) {
                                                                        BooleanProperty _booleanProp = (BooleanProperty)patt0$temp;
                                                                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_booleanProp, (Comparable)Boolean.valueOf(true)), 3);
                                                                    }
                                                                    if (world instanceof Level) {
                                                                        Level _level = (Level)world;
                                                                        if (!_level.isClientSide()) {
                                                                            _level.playSound(null, BlockPos.containing((double)(x + 1.0), (double)y, (double)(z + 2.0)), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 0.9f);
                                                                        } else {
                                                                            _level.playLocalSound(x + 1.0, y, z + 2.0, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 0.9f, false);
                                                                        }
                                                                    }
                                                                    TotallyLegitMod.queueServerWork(1, () -> {
                                                                        BlockPos _pos = BlockPos.containing((double)(x + 2.0), (double)y, (double)(z + 1.0));
                                                                        BlockState _bs = world.getBlockState(_pos);
                                                                        Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("eye");
                                                                        if (patt0$temp instanceof BooleanProperty) {
                                                                            BooleanProperty _booleanProp = (BooleanProperty)patt0$temp;
                                                                            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_booleanProp, (Comparable)Boolean.valueOf(true)), 3);
                                                                        }
                                                                        if (world instanceof Level) {
                                                                            Level _level = (Level)world;
                                                                            if (!_level.isClientSide()) {
                                                                                _level.playSound(null, BlockPos.containing((double)(x + 2.0), (double)y, (double)(z + 1.0)), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.0f);
                                                                            } else {
                                                                                _level.playLocalSound(x + 2.0, y, z + 1.0, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.0f, false);
                                                                            }
                                                                        }
                                                                        TotallyLegitMod.queueServerWork(1, () -> {
                                                                            BlockPos _pos = BlockPos.containing((double)(x + 2.0), (double)y, (double)(z + 0.0));
                                                                            BlockState _bs = world.getBlockState(_pos);
                                                                            Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("eye");
                                                                            if (patt0$temp instanceof BooleanProperty) {
                                                                                BooleanProperty _booleanProp = (BooleanProperty)patt0$temp;
                                                                                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_booleanProp, (Comparable)Boolean.valueOf(true)), 3);
                                                                            }
                                                                            if (world instanceof Level) {
                                                                                Level _level = (Level)world;
                                                                                if (!_level.isClientSide()) {
                                                                                    _level.playSound(null, BlockPos.containing((double)(x + 2.0), (double)y, (double)(z + 0.0)), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.1f);
                                                                                } else {
                                                                                    _level.playLocalSound(x + 2.0, y, z + 0.0, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.1f, false);
                                                                                }
                                                                            }
                                                                            TotallyLegitMod.queueServerWork(1, () -> {
                                                                                BlockPos _pos = BlockPos.containing((double)(x + 2.0), (double)y, (double)(z - 1.0));
                                                                                BlockState _bs = world.getBlockState(_pos);
                                                                                Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("eye");
                                                                                if (patt0$temp instanceof BooleanProperty) {
                                                                                    BooleanProperty _booleanProp = (BooleanProperty)patt0$temp;
                                                                                    world.setBlock(_pos, (BlockState)_bs.setValue((Property)_booleanProp, (Comparable)Boolean.valueOf(true)), 3);
                                                                                }
                                                                                if (world instanceof Level) {
                                                                                    Level _level = (Level)world;
                                                                                    if (!_level.isClientSide()) {
                                                                                        _level.playSound(null, BlockPos.containing((double)(x + 2.0), (double)y, (double)(z - 1.0)), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.2f);
                                                                                    } else {
                                                                                        _level.playLocalSound(x + 2.0, y, z - 1.0, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.2f, false);
                                                                                    }
                                                                                }
                                                                                TotallyLegitMod.queueServerWork(1, () -> {
                                                                                    BlockPos _pos = BlockPos.containing((double)(x + 1.0), (double)y, (double)(z - 2.0));
                                                                                    BlockState _bs = world.getBlockState(_pos);
                                                                                    Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("eye");
                                                                                    if (patt0$temp instanceof BooleanProperty) {
                                                                                        BooleanProperty _booleanProp = (BooleanProperty)patt0$temp;
                                                                                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_booleanProp, (Comparable)Boolean.valueOf(true)), 3);
                                                                                    }
                                                                                    if (world instanceof Level) {
                                                                                        Level _level = (Level)world;
                                                                                        if (!_level.isClientSide()) {
                                                                                            _level.playSound(null, BlockPos.containing((double)(x + 1.0), (double)y, (double)(z - 2.0)), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.3f);
                                                                                        } else {
                                                                                            _level.playLocalSound(x + 1.0, y, z - 2.0, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.3f, false);
                                                                                        }
                                                                                    }
                                                                                    TotallyLegitMod.queueServerWork(1, () -> {
                                                                                        BlockPos _pos = BlockPos.containing((double)(x + 0.0), (double)y, (double)(z - 2.0));
                                                                                        BlockState _bs = world.getBlockState(_pos);
                                                                                        Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("eye");
                                                                                        if (patt0$temp instanceof BooleanProperty) {
                                                                                            BooleanProperty _booleanProp = (BooleanProperty)patt0$temp;
                                                                                            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_booleanProp, (Comparable)Boolean.valueOf(true)), 3);
                                                                                        }
                                                                                        if (world instanceof Level) {
                                                                                            Level _level = (Level)world;
                                                                                            if (!_level.isClientSide()) {
                                                                                                _level.playSound(null, BlockPos.containing((double)(x + 0.0), (double)y, (double)(z - 2.0)), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.4f);
                                                                                            } else {
                                                                                                _level.playLocalSound(x + 0.0, y, z - 2.0, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.4f, false);
                                                                                            }
                                                                                        }
                                                                                        TotallyLegitMod.queueServerWork(1, () -> {
                                                                                            BlockPos _pos = BlockPos.containing((double)(x - 1.0), (double)y, (double)(z - 2.0));
                                                                                            BlockState _bs = world.getBlockState(_pos);
                                                                                            Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("eye");
                                                                                            if (patt0$temp instanceof BooleanProperty) {
                                                                                                BooleanProperty _booleanProp = (BooleanProperty)patt0$temp;
                                                                                                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_booleanProp, (Comparable)Boolean.valueOf(true)), 3);
                                                                                            }
                                                                                            if (world instanceof Level) {
                                                                                                Level _level = (Level)world;
                                                                                                if (!_level.isClientSide()) {
                                                                                                    _level.playSound(null, BlockPos.containing((double)(x - 1.0), (double)y, (double)(z - 2.0)), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.5f);
                                                                                                } else {
                                                                                                    _level.playLocalSound(x - 1.0, y, z - 2.0, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.5f, false);
                                                                                                }
                                                                                            }
                                                                                            TotallyLegitMod.queueServerWork(1, () -> {
                                                                                                BlockPos _pos = BlockPos.containing((double)(x - 2.0), (double)y, (double)(z - 1.0));
                                                                                                BlockState _bs = world.getBlockState(_pos);
                                                                                                Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("eye");
                                                                                                if (patt0$temp instanceof BooleanProperty) {
                                                                                                    BooleanProperty _booleanProp = (BooleanProperty)patt0$temp;
                                                                                                    world.setBlock(_pos, (BlockState)_bs.setValue((Property)_booleanProp, (Comparable)Boolean.valueOf(true)), 3);
                                                                                                }
                                                                                                if (world instanceof Level) {
                                                                                                    Level _level = (Level)world;
                                                                                                    if (!_level.isClientSide()) {
                                                                                                        _level.playSound(null, BlockPos.containing((double)(x - 2.0), (double)y, (double)(z - 1.0)), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.6f);
                                                                                                    } else {
                                                                                                        _level.playLocalSound(x - 2.0, y, z - 1.0, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.6f, false);
                                                                                                    }
                                                                                                }
                                                                                                TotallyLegitMod.queueServerWork(1, () -> {
                                                                                                    BlockPos _pos = BlockPos.containing((double)(x - 2.0), (double)y, (double)(z - 0.0));
                                                                                                    BlockState _bs = world.getBlockState(_pos);
                                                                                                    Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("eye");
                                                                                                    if (patt0$temp instanceof BooleanProperty) {
                                                                                                        BooleanProperty _booleanProp = (BooleanProperty)patt0$temp;
                                                                                                        world.setBlock(_pos, (BlockState)_bs.setValue((Property)_booleanProp, (Comparable)Boolean.valueOf(true)), 3);
                                                                                                    }
                                                                                                    if (world instanceof Level) {
                                                                                                        Level _level = (Level)world;
                                                                                                        if (!_level.isClientSide()) {
                                                                                                            _level.playSound(null, BlockPos.containing((double)(x - 2.0), (double)y, (double)(z - 0.0)), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.7f);
                                                                                                        } else {
                                                                                                            _level.playLocalSound(x - 2.0, y, z - 0.0, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.7f, false);
                                                                                                        }
                                                                                                    }
                                                                                                    TotallyLegitMod.queueServerWork(1, () -> {
                                                                                                        BlockPos _pos = BlockPos.containing((double)(x - 2.0), (double)y, (double)(z + 1.0));
                                                                                                        BlockState _bs = world.getBlockState(_pos);
                                                                                                        Property patt0$temp = _bs.getBlock().getStateDefinition().getProperty("eye");
                                                                                                        if (patt0$temp instanceof BooleanProperty) {
                                                                                                            BooleanProperty _booleanProp = (BooleanProperty)patt0$temp;
                                                                                                            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_booleanProp, (Comparable)Boolean.valueOf(true)), 3);
                                                                                                        }
                                                                                                        if (world instanceof Level) {
                                                                                                            Level _level = (Level)world;
                                                                                                            if (!_level.isClientSide()) {
                                                                                                                _level.playSound(null, BlockPos.containing((double)(x - 2.0), (double)y, (double)(z + 1.0)), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.8f);
                                                                                                            } else {
                                                                                                                _level.playLocalSound(x - 2.0, y, z + 1.0, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal_frame.fill")), SoundSource.BLOCKS, 1.0f, 1.8f, false);
                                                                                                            }
                                                                                                        }
                                                                                                        TotallyLegitMod.queueServerWork(10, () -> {
                                                                                                            ServerLevel _level;
                                                                                                            if (world instanceof ServerLevel) {
                                                                                                                _level = (ServerLevel)world;
                                                                                                                _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal((String)""), _level.getServer(), null).withSuppressedOutput(), "fill ~-1 ~ ~-1 ~1 ~ ~1 minecraft:end_portal");
                                                                                                            }
                                                                                                            if (world instanceof Level) {
                                                                                                                _level = (Level)world;
                                                                                                                if (!_level.isClientSide()) {
                                                                                                                    _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal.spawn")), SoundSource.BLOCKS, 1.0f, 1.0f);
                                                                                                                } else {
                                                                                                                    _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse((String)"block.end_portal.spawn")), SoundSource.BLOCKS, 1.0f, 1.0f, false);
                                                                                                                }
                                                                                                            }
                                                                                                            if (world instanceof ServerLevel) {
                                                                                                                _level = (ServerLevel)world;
                                                                                                                LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create((Level)_level, EntitySpawnReason.TRIGGERED);
                                                                                                                entityToSpawn.moveTo(Vec3.atBottomCenterOf((Vec3i)BlockPos.containing((double)x, (double)y, (double)z)));
                                                                                                                entityToSpawn.setVisualOnly(true);
                                                                                                                _level.addFreshEntity((Entity)entityToSpawn);
                                                                                                            }
                                                                                                        });
                                                                                                    });
                                                                                                });
                                                                                            });
                                                                                        });
                                                                                    });
                                                                                });
                                                                            });
                                                                        });
                                                                    });
                                                                });
                                                            });
                                                        });
                                                    });
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
        }
    }
}

