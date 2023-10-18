package com.cosmicgelatin.peculiars.core.data.server.tags;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class PeculiarsBlockTagsProvider extends BlockTagsProvider {

    public PeculiarsBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, Peculiars.MODID, existingFileHelper);
    }

    @Override
    public void addTags() {

        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                PeculiarsBlocks.ALOE_ICE_CREAM_BLOCK.get(),
                PeculiarsBlocks.PASSIONFRUIT_ICE_CREAM_BLOCK.get(),
                PeculiarsBlocks.YUCCA_ICE_CREAM_BLOCK.get()
        );
        tag(BlockTags.CAULDRONS).add(
                PeculiarsBlocks.YUCCA_MILKSHAKE_CAULDRON.get(),
                PeculiarsBlocks.ALOE_MILKSHAKE_CAULDRON.get(),
                PeculiarsBlocks.PASSIONFRUIT_MILKSHAKE_CAULDRON.get()
        );
    }
}
