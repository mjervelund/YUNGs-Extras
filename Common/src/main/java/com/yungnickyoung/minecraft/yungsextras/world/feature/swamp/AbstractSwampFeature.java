package com.yungnickyoung.minecraft.yungsextras.world.feature.swamp;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.yungsextras.module.FeatureProcessorModule;
import com.yungnickyoung.minecraft.yungsextras.world.feature.AbstractNbtFeature;
import com.yungnickyoung.minecraft.yungsextras.world.processor.INbtFeatureProcessor;

import java.util.List;

public abstract class AbstractSwampFeature<C> extends AbstractNbtFeature<C> {
    public AbstractSwampFeature(C config) {
        super(config);
    }

    /**
     * We override this method to supply the processors specific to this template feature.
     */
    @Override
    protected List<INbtFeatureProcessor> useProcessors() {
        return Lists.newArrayList(
                FeatureProcessorModule.SWAMP_FEATURE_PROCESSOR
        );
    }
}
