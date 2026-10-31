package com.yungnickyoung.minecraft.yungsextras.world.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;

/**
 * Stand-in for vanilla's FeaturePlaceContext, which was removed in 26.3 (features now receive the level, generator,
 * random and origin directly and carry their own config). Holds the feature's config for the NBT features.
 */
public record FeaturePlaceContext<C>(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin, C config) {
}
