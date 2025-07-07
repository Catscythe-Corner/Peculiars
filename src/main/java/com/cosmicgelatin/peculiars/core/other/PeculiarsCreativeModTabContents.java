package com.cosmicgelatin.peculiars.core.other;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;

import static com.cosmicgelatin.peculiars.core.registry.PeculiarsBlocks.*;
import static com.cosmicgelatin.peculiars.core.registry.PeculiarsItems.*;

public class PeculiarsCreativeModTabContents {

    public static void buildSeasonalsCreativeTabContents() {
        CreativeModeTabContentsPopulator.mod(Peculiars.MODID)
                .tab(CreativeModeTabs.FOOD_AND_DRINKS)
                .addItems(
                        YUCCA_ICE_CREAM, YUCCA_MILKSHAKE, YUCCA_FUDGE, YUCCA_CAKE,
                        ALOE_ICE_CREAM, ALOE_MILKSHAKE, ALOE_JELLY_SLICE, ALOE_BERRY_SMOOTHIE, ALOE_CAKE,
                        PASSION_FRUIT_ICE_CREAM, PASSION_FRUIT_MILKSHAKE, PASSION_FRUIT_CAKE, TROPICAL_SALAD
                )
                .tab(CreativeModeTabs.BUILDING_BLOCKS)
                .addItems(
                        YUCCA_ICE_CREAM_BLOCK, ALOE_ICE_CREAM_BLOCK, PASSION_FRUIT_ICE_CREAM_BLOCK
                )
        ;
    }
}
