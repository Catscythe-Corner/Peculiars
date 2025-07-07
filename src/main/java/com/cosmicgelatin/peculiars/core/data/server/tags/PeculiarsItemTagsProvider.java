package com.cosmicgelatin.peculiars.core.data.server.tags;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsItems;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PeculiarsItemTagsProvider extends ItemTagsProvider {

    public PeculiarsItemTagsProvider(PackOutput pGenerator, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pLookupProvider, pBlockTags, Peculiars.MODID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider provider) {
        tag(NeapolitanItemTags.ICE_CREAM).add(
                PeculiarsItems.YUCCA_ICE_CREAM.get(),
                PeculiarsItems.ALOE_ICE_CREAM.get(),
                PeculiarsItems.PASSION_FRUIT_ICE_CREAM.get()
        );
    }
}
