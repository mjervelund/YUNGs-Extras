package com.yungnickyoung.minecraft.yungsextras.world.placement;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.yungsextras.module.PlacementModifierTypeModule;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;


import java.util.stream.Stream;

/**
 * Properly initializes this placement's Random seed (which MC doesn't do on its own)
 * to maximize variability in feature placement.
 */


public class RngInitializerPlacement implements PlacementModifier {
    private static final RngInitializerPlacement INSTANCE = new RngInitializerPlacement();
    public static final MapCodec<RngInitializerPlacement> CODEC = MapCodec.unit(() -> INSTANCE);

    public static RngInitializerPlacement randomize() {
        return INSTANCE;
    }

    private Stream<BlockPos> positions(PlacementContext placementContext, RandomSource random, BlockPos pos) {
        long a = random.nextLong() | 1L;
        long b = random.nextLong() | 1L;
        random.setSeed(((pos.getX() * a * 341873128712L + 12412146) * (pos.getZ() * b * 132897987541L + 5813717)) ^ 423487234);
        return Stream.of(pos);
    }

    @Override
    public void modify(PlacementContext placementContext, RandomSource randomSource, BlockPos blockPos, java.util.function.Consumer<BlockPos> output) {
        positions(placementContext, randomSource, blockPos).forEach(output);
    }

    @Override
    public MapCodec<? extends PlacementModifier> codec() {
        return CODEC;
    }
}
