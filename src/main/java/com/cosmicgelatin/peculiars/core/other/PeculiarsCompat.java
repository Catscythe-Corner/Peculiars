package com.cosmicgelatin.peculiars.core.other;

import com.cosmicgelatin.peculiars.core.registry.PeculiarsItems;
import com.teamabnormals.blueprint.core.util.DataUtil;

public class PeculiarsCompat {

    public static void registerCompostables() {
        DataUtil.registerCompostable(PeculiarsItems.YUCCA_FUDGE.get(), 0.85F);
        DataUtil.registerCompostable(PeculiarsItems.ALOE_JELLY_SLICE.get(), 0.65F);

        DataUtil.registerCompostable(PeculiarsItems.YUCCA_CAKE.get(), 1.0F);
        DataUtil.registerCompostable(PeculiarsItems.ALOE_CAKE.get(), 1.0F);
        DataUtil.registerCompostable(PeculiarsItems.PASSIONFRUIT_CAKE.get(), 1.0F);
    }
}
