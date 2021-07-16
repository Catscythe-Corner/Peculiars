package com.cosmicgelatin.peculiars.core.registry;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.minecraftabnormals.neapolitan.common.block.FlavoredCakeBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Peculiars.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PeculiarsBlocks {
    public static final BlockSubRegistryHelper ATMOSPHERIC = Peculiars.REGISTRY_ATMOSPHERIC.getBlockSubHelper();

    public static final RegistryObject<Block> YUCCA_ICE_CREAM_BLOCK = ATMOSPHERIC.createBlock("yucca_ice_cream_block", () -> new Block(Properties.YUCCA_ICE_CREAM_BLOCK), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> YUCCA_CAKE = ATMOSPHERIC.createBlockNoItem("yucca_cake", () -> new FlavoredCakeBlock(PeculiarsItems.Foods.YUCCA_CAKE, null, Properties.YUCCA_CAKE));

    public static final RegistryObject<Block> ALOE_ICE_CREAM_BLOCK = ATMOSPHERIC.createBlock("aloe_ice_cream_block", () -> new Block(Properties.ALOE_ICE_CREAM_BLOCK), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ALOE_CAKE = ATMOSPHERIC.createBlockNoItem("aloe_cake", () -> new FlavoredCakeBlock(PeculiarsItems.Foods.ALOE_CAKE, null, Properties.ALOE_CAKE));

    public static final RegistryObject<Block> PASSIONFRUIT_ICE_CREAM_BLOCK = ATMOSPHERIC.createBlock("passionfruit_ice_cream_block", () -> new Block(Properties.PASSIONFRUIT_ICE_CREAM_BLOCK), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> PASSIONFRUIT_CAKE = ATMOSPHERIC.createBlockNoItem("passionfruit_cake", () -> new FlavoredCakeBlock(PeculiarsItems.Foods.PASSIONFRUIT_CAKE, null, Properties.PASSIONFRUIT_CAKE));

    static class Properties {
        public static final AbstractBlock.Properties YUCCA_ICE_CREAM_BLOCK = AbstractBlock.Properties.create(Material.SNOW_BLOCK, MaterialColor.LIME).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.2F).sound(SoundType.SNOW);
        public static final AbstractBlock.Properties YUCCA_CAKE = AbstractBlock.Properties.create(Material.CAKE, MaterialColor.LIME).hardnessAndResistance(0.5F).sound(SoundType.CLOTH);

        public static final AbstractBlock.Properties ALOE_ICE_CREAM_BLOCK = AbstractBlock.Properties.create(Material.SNOW_BLOCK, MaterialColor.LIME).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.2F).sound(SoundType.SNOW);
        public static final AbstractBlock.Properties ALOE_CAKE = AbstractBlock.Properties.create(Material.CAKE, MaterialColor.LIME).hardnessAndResistance(0.5F).sound(SoundType.CLOTH);

        public static final AbstractBlock.Properties PASSIONFRUIT_ICE_CREAM_BLOCK = AbstractBlock.Properties.create(Material.SNOW_BLOCK, MaterialColor.YELLOW).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.2F).sound(SoundType.SNOW);
        public static final AbstractBlock.Properties PASSIONFRUIT_CAKE = AbstractBlock.Properties.create(Material.CAKE, MaterialColor.YELLOW).hardnessAndResistance(0.5F).sound(SoundType.CLOTH);
    }
}
