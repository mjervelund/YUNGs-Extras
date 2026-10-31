package com.yungnickyoung.minecraft.yungsextras.world.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;

/** Empty feature config (vanilla's NoneFeatureConfiguration no longer exists on 26.3). */
public final class NoneFeatureConfiguration {
    public static final NoneFeatureConfiguration INSTANCE = new NoneFeatureConfiguration();
    public static final Codec<NoneFeatureConfiguration> CODEC = MapCodec.unit(INSTANCE).codec();

    private NoneFeatureConfiguration() {
    }
}
