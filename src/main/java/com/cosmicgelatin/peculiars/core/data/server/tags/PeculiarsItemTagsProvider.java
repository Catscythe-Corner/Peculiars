package com.cosmicgelatin.peculiars.core.data.server.tags;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsItems;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class PeculiarsItemTagsProvider extends ItemTagsProvider {

    public PeculiarsItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, Peculiars.MODID, existingFileHelper);
    }

    protected void addTags() {
        tag(NeapolitanItemTags.ICE_CREAM).add(
                PeculiarsItems.YUCCA_ICE_CREAM.get(),
                PeculiarsItems.ALOE_ICE_CREAM.get(),
                PeculiarsItems.PASSIONFRUIT_ICE_CREAM.get()
        );
    }
}
