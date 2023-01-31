package com.cosmicgelatin.peculiars.core.registry;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.neapolitan.common.block.FlavoredCakeBlock;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Peculiars.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PeculiarsBlocks {
    public static final BlockSubRegistryHelper ATMOSPHERIC = Peculiars.REGISTRY_HELPER.getBlockSubHelper();

    public static final RegistryObject<Block> YUCCA_ICE_CREAM_BLOCK = ATMOSPHERIC.createBlock("yucca_ice_cream_block", () -> new Block(Properties.YUCCA_ICE_CREAM_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> YUCCA_CAKE = ATMOSPHERIC.createBlockNoItem("yucca_cake", () -> new FlavoredCakeBlock(PeculiarsItems.Foods.YUCCA_CAKE, Properties.YUCCA_CAKE));

    public static final RegistryObject<Block> ALOE_ICE_CREAM_BLOCK = ATMOSPHERIC.createBlock("aloe_ice_cream_block", () -> new Block(Properties.ALOE_ICE_CREAM_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ALOE_CAKE = ATMOSPHERIC.createBlockNoItem("aloe_cake", () -> new FlavoredCakeBlock(PeculiarsItems.Foods.ALOE_CAKE, Properties.ALOE_CAKE));

    public static final RegistryObject<Block> PASSIONFRUIT_ICE_CREAM_BLOCK = ATMOSPHERIC.createBlock("passionfruit_ice_cream_block", () -> new Block(Properties.PASSIONFRUIT_ICE_CREAM_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> PASSIONFRUIT_CAKE = ATMOSPHERIC.createBlockNoItem("passionfruit_cake", () -> new FlavoredCakeBlock(PeculiarsItems.Foods.PASSIONFRUIT_CAKE, Properties.PASSIONFRUIT_CAKE));

    static class Properties {
        public static final Block.Properties YUCCA_ICE_CREAM_BLOCK = Block.Properties.of(Material.SNOW, MaterialColor.COLOR_LIGHT_GREEN).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW); //SHOVEL
        public static final Block.Properties YUCCA_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.COLOR_LIGHT_GREEN).strength(0.5F).sound(SoundType.WOOL);

        public static final Block.Properties ALOE_ICE_CREAM_BLOCK = Block.Properties.of(Material.SNOW, MaterialColor.COLOR_LIGHT_GREEN).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW); //SHOVEL
        public static final Block.Properties ALOE_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.COLOR_LIGHT_GREEN).strength(0.5F).sound(SoundType.WOOL);

        public static final Block.Properties PASSIONFRUIT_ICE_CREAM_BLOCK = Block.Properties.of(Material.SNOW, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW); //SHOVEL
        public static final Block.Properties PASSIONFRUIT_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.COLOR_YELLOW).strength(0.5F).sound(SoundType.WOOL);
    }
}
