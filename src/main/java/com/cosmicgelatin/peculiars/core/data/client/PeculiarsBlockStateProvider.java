package com.cosmicgelatin.peculiars.core.data.client;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsBlocks;
import com.teamabnormals.neapolitan.common.block.FlavoredCandleCakeBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.cosmicgelatin.peculiars.core.data.PeculiarsDatagenUtil.*;

public class PeculiarsBlockStateProvider extends BlockStateProvider {

    public PeculiarsBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Peculiars.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        milkshakeCauldron(PeculiarsBlocks.YUCCA_MILKSHAKE_CAULDRON);
        milkshakeCauldron(PeculiarsBlocks.ALOE_MILKSHAKE_CAULDRON);
        milkshakeCauldron(PeculiarsBlocks.PASSIONFRUIT_MILKSHAKE_CAULDRON);

    }

    private void basicBlock(Supplier<? extends Block> block) {
        simpleBlock(block.get());
    }

    private void modCakeBlock(Supplier<? extends Block> block) {
        getVariantBuilder(block.get()).forAllStates(blockState -> {
            int bites = blockState.getValue(BlockStateProperties.BITES);
            String slices = "";

            for (int i = 0; i < bites; i++) {
                slices = "_slice" + bites;
            }

            String suffix = bites > 0 ? slices : "";
            String parentName = bites > 0 ? "cake" + slices : "cake";

            ModelFile modelFile = models().withExistingParent(name(block.get()) + suffix, vanillaBlockLocation(parentName))
                    .texture("particle", modBlockLocation(name(block.get()) + "_side"))
                    .texture("bottom", modBlockLocation(name(block.get()) + "_bottom"))
                    .texture("top", modBlockLocation(name(block.get()) + "_top"))
                    .texture("side", modBlockLocation(name(block.get()) + "_side"))
                    .texture("inside", modBlockLocation(name(block.get()) + "_inner"));
            return ConfiguredModel.builder().modelFile(modelFile).build();

        });
    }

    public void candleCake(FlavoredCandleCakeBlock block) {
        Block candle = block.getCandle();
        Block cake = block.getCake();

        ModelFile candleCake = models().withExistingParent(name(block), "block/template_cake_with_candle")
                .texture("candle", blockTexture(candle))
                .texture("bottom", modBlockLocation(name(cake) + "_bottom"))
                .texture("side", modBlockLocation(name(cake) + "_side"))
                .texture("top", modBlockLocation(name(cake) + "_top"))
                .texture("particle", modBlockLocation(name(cake) + "_side"));

        ModelFile candleCakeLit = models().withExistingParent(name(block) + "_lit", "block/template_cake_with_candle")
                .texture("candle", vanillaBlockLocation(name(candle) + "_lit"))
                .texture("bottom", modBlockLocation(name(cake) + "_bottom"))
                .texture("side", modBlockLocation(name(cake) + "_side"))
                .texture("top", modBlockLocation(name(cake) + "_top"))
                .texture("particle", modBlockLocation(name(cake) + "_side"));

        this.candleCakeBlock(block, (state -> state.getValue(BlockStateProperties.LIT) ? candleCakeLit : candleCake));
    }

    public void candleCakeBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
        this.getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(modelFunc.apply(state)).build());
    }

    public void milkshakeCauldron(Supplier<Block> block) {
        getVariantBuilder(block.get()).forAllStates(blockState -> {
            String cauldron = name(Blocks.CAULDRON);
            int level = blockState.getValue(BlockStateProperties.LEVEL_CAULDRON);
            String templateSuffix = switch (level) {
                case 1 -> "_level1";
                case 2 -> "_level2";
                case 3 -> "_full";
                default -> "";
            };

            ModelFile modelFile = models().withExistingParent(name(block.get()) + templateSuffix, vanillaBlockLocation("template_cauldron" + templateSuffix))
                   .texture("content", modBlockLocation(name(block.get()).replace("_milkshake_cauldron", "") + "/" + name(block.get()) + "_content"))
                   .texture("inside", vanillaBlockLocation(cauldron + "_side"))
                   .texture("particle", vanillaBlockLocation(cauldron + "_inner"))
                   .texture("top", vanillaBlockLocation(cauldron + "_top"))
                   .texture("bottom", vanillaBlockLocation(cauldron + "_bottom"))
                   .texture("side", vanillaBlockLocation(cauldron + "_side"));

            return ConfiguredModel.builder().modelFile(modelFile).build();
        });

    }
}
