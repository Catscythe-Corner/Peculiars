package com.cosmicgelatin.peculiars.core.registry;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.cosmicgelatin.peculiars.core.other.PeculiarsCauldronInteractions;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.neapolitan.common.block.FlavoredCakeBlock;
import com.teamabnormals.neapolitan.common.block.MilkshakeCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Peculiars.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PeculiarsBlocks {
    public static final BlockSubRegistryHelper HELPER = Peculiars.REGISTRY_HELPER.getBlockSubHelper();

    public static final RegistryObject<Block> YUCCA_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("yucca_milkshake_cauldron", () -> new MilkshakeCauldronBlock(PeculiarsCauldronInteractions.YUCCA_MILKSHAKE.map()));
    public static final RegistryObject<Block> YUCCA_ICE_CREAM_BLOCK = HELPER.createBlock("yucca_ice_cream_block", () -> new Block(Properties.YUCCA_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> YUCCA_CAKE_BLOCK = HELPER.createBlockNoItem("yucca_cake", () -> new FlavoredCakeBlock(PeculiarsItems.Foods.YUCCA_CAKE, Properties.YUCCA_CAKE));

    public static final RegistryObject<Block> ALOE_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("aloe_milkshake_cauldron", () -> new MilkshakeCauldronBlock(PeculiarsCauldronInteractions.ALOE_MILKSHAKE.map()));
    public static final RegistryObject<Block> ALOE_ICE_CREAM_BLOCK = HELPER.createBlock("aloe_ice_cream_block", () -> new Block(Properties.ALOE_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> ALOE_CAKE_BLOCK = HELPER.createBlockNoItem("aloe_cake", () -> new FlavoredCakeBlock(PeculiarsItems.Foods.ALOE_CAKE, Properties.ALOE_CAKE));

    public static final RegistryObject<Block> PASSION_FRUIT_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("passion_fruit_milkshake_cauldron", () -> new MilkshakeCauldronBlock(PeculiarsCauldronInteractions.PASSION_FRUIT_MILKSHAKE.map()));
    public static final RegistryObject<Block> PASSION_FRUIT_ICE_CREAM_BLOCK = HELPER.createBlock("passion_fruit_ice_cream_block", () -> new Block(Properties.PASSION_FRUIT_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> PASSION_FRUIT_CAKE_BLOCK = HELPER.createBlockNoItem("passion_fruit_cake", () -> new FlavoredCakeBlock(PeculiarsItems.Foods.PASSION_FRUIT_CAKE, Properties.PASSION_FRUIT_CAKE));

    static class Properties {
        public static final Block.Properties YUCCA_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW);
        public static final Block.Properties YUCCA_CAKE = Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(0.5F).sound(SoundType.WOOL);

        public static final Block.Properties ALOE_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW);
        public static final Block.Properties ALOE_CAKE = Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(0.5F).sound(SoundType.WOOL);

        public static final Block.Properties PASSION_FRUIT_ICE_CREAM_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW);
        public static final Block.Properties PASSION_FRUIT_CAKE = Block.Properties.of().strength(0.5F).mapColor(MapColor.COLOR_YELLOW).sound(SoundType.WOOL);
    }
}
