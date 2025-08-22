/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.commands.CommandSource
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySpawnReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LightningBolt
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec2
 *  net.minecraft.world.phys.Vec3
 */
package net.knarfy.totallylegit.procedures;

import net.knarfy.totallylegit.TotallyLegitMod;
import net.knarfy.totallylegit.init.TotallyLegitModGameRules;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class NKeyOnKeyPressedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        ServerLevel _serverLevelGR0;
        if (world instanceof ServerLevel && (_serverLevelGR0 = (ServerLevel)world).getGameRules().getBoolean(TotallyLegitModGameRules.SPAWN_PORTALS)) {
            world.setBlock(BlockPos.containing((double)(x - 1.0), (double)(y - 1.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
            world.levelEvent(2001, BlockPos.containing((double)(x - 1.0), (double)(y - 1.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
            TotallyLegitMod.queueServerWork(1, () -> {
                world.setBlock(BlockPos.containing((double)x, (double)(y - 1.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                world.levelEvent(2001, BlockPos.containing((double)x, (double)(y - 1.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                TotallyLegitMod.queueServerWork(1, () -> {
                    world.setBlock(BlockPos.containing((double)(x + 1.0), (double)(y - 1.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                    world.levelEvent(2001, BlockPos.containing((double)(x + 1.0), (double)(y - 1.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                    TotallyLegitMod.queueServerWork(1, () -> {
                        world.setBlock(BlockPos.containing((double)(x + 2.0), (double)(y - 1.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                        world.levelEvent(2001, BlockPos.containing((double)(x + 2.0), (double)(y - 1.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                        TotallyLegitMod.queueServerWork(1, () -> {
                            world.setBlock(BlockPos.containing((double)(x + 2.0), (double)(y - 0.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                            world.levelEvent(2001, BlockPos.containing((double)(x + 2.0), (double)(y - 0.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                            TotallyLegitMod.queueServerWork(1, () -> {
                                world.setBlock(BlockPos.containing((double)(x + 2.0), (double)(y + 1.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                                world.levelEvent(2001, BlockPos.containing((double)(x + 2.0), (double)(y + 1.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                                TotallyLegitMod.queueServerWork(1, () -> {
                                    world.setBlock(BlockPos.containing((double)(x + 2.0), (double)(y + 2.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                                    world.levelEvent(2001, BlockPos.containing((double)(x + 2.0), (double)(y + 2.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                                    TotallyLegitMod.queueServerWork(1, () -> {
                                        world.setBlock(BlockPos.containing((double)(x + 2.0), (double)(y + 3.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                                        world.levelEvent(2001, BlockPos.containing((double)(x + 2.0), (double)(y + 3.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                                        TotallyLegitMod.queueServerWork(1, () -> {
                                            world.setBlock(BlockPos.containing((double)(x + 1.0), (double)(y + 3.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                                            world.levelEvent(2001, BlockPos.containing((double)(x + 1.0), (double)(y + 3.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                                            TotallyLegitMod.queueServerWork(1, () -> {
                                                world.setBlock(BlockPos.containing((double)(x + 0.0), (double)(y + 3.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                                                world.levelEvent(2001, BlockPos.containing((double)(x + 0.0), (double)(y + 3.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                                                TotallyLegitMod.queueServerWork(1, () -> {
                                                    world.setBlock(BlockPos.containing((double)(x - 1.0), (double)(y + 3.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                                                    world.levelEvent(2001, BlockPos.containing((double)(x - 1.0), (double)(y + 3.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                                                    TotallyLegitMod.queueServerWork(1, () -> {
                                                        world.setBlock(BlockPos.containing((double)(x - 1.0), (double)(y + 2.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                                                        world.levelEvent(2001, BlockPos.containing((double)(x - 1.0), (double)(y + 2.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                                                        TotallyLegitMod.queueServerWork(1, () -> {
                                                            world.setBlock(BlockPos.containing((double)(x - 1.0), (double)(y + 1.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                                                            world.levelEvent(2001, BlockPos.containing((double)(x - 1.0), (double)(y + 1.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                                                            TotallyLegitMod.queueServerWork(1, () -> {
                                                                world.setBlock(BlockPos.containing((double)(x - 1.0), (double)(y + 0.0), (double)z), Blocks.OBSIDIAN.defaultBlockState(), 3);
                                                                world.levelEvent(2001, BlockPos.containing((double)(x - 1.0), (double)(y + 0.0), (double)z), Block.getId((BlockState)Blocks.CRYING_OBSIDIAN.defaultBlockState()));
                                                                TotallyLegitMod.queueServerWork(1, () -> {
                                                                    if (world instanceof ServerLevel) {
                                                                        ServerLevel _level = (ServerLevel)world;
                                                                        _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", (Component)Component.literal((String)""), _level.getServer(), null).withSuppressedOutput(), "fill ~ ~ ~ ~1 ~2 ~ air");
                                                                    }
                                                                    TotallyLegitMod.queueServerWork(9, () -> {
                                                                        if (world instanceof ServerLevel) {
                                                                            ServerLevel _level = (ServerLevel)world;
                                                                            LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create((Level)_level, EntitySpawnReason.TRIGGERED);
                                                                            entityToSpawn.moveTo(Vec3.atBottomCenterOf((Vec3i)BlockPos.containing((double)x, (double)y, (double)z)));
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
        }
    }
}

