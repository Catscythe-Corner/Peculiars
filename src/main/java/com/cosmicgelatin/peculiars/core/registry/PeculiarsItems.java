package com.cosmicgelatin.peculiars.core.registry;

import com.cosmicgelatin.peculiars.common.item.PeculiarsMilkshakeItem;
import com.cosmicgelatin.peculiars.core.Peculiars;
import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.minecraftabnormals.atmospheric.core.registry.AtmosphericEffects;
import com.minecraftabnormals.neapolitan.common.item.HealingDrinkItem;
import com.minecraftabnormals.neapolitan.core.registry.NeapolitanEffects;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Peculiars.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PeculiarsItems {
    public static final ItemSubRegistryHelper ATMOSPHERIC = Peculiars.REGISTRY_ATMOSPHERIC.getItemSubHelper();

    public static final RegistryObject<Item> YUCCA_ICE_CREAM = ATMOSPHERIC.createItem("yucca_ice_cream", () -> new SoupItem(new Item.Properties().food(Foods.YUCCA_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> YUCCA_MILKSHAKE = ATMOSPHERIC.createItem("yucca_milkshake", () -> new PeculiarsMilkshakeItem(new Item.Properties().food(Foods.YUCCA_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> YUCCA_FUDGE = ATMOSPHERIC.createItem("yucca_fudge", () -> new Item(new Item.Properties().food(Foods.YUCCA_FUDGE).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> YUCCA_CAKE = ATMOSPHERIC.createItem("yucca_cake", () -> new BlockItem(PeculiarsBlocks.YUCCA_CAKE.get(), new Item.Properties().tab(ItemGroup.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> ALOE_ICE_CREAM = ATMOSPHERIC.createItem("aloe_ice_cream", () -> new SoupItem(new Item.Properties().food(Foods.ALOE_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> ALOE_MILKSHAKE = ATMOSPHERIC.createItem("aloe_milkshake", () -> new PeculiarsMilkshakeItem(new Item.Properties().food(Foods.ALOE_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> ALOE_JELLY_SLICE = ATMOSPHERIC.createItem("aloe_jelly_slice", () -> new Item(new Item.Properties().food(Foods.ALOE_JELLY_SLICE).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> ALOE_BERRY_SMOOTHIE = ATMOSPHERIC.createItem("aloe_berry_smoothie", () -> new HealingDrinkItem(2.0F, new Item.Properties().food(Foods.ALOE_BERRY_SMOOTHIE).stacksTo(16).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> ALOE_CAKE = ATMOSPHERIC.createItem("aloe_cake", () -> new BlockItem(PeculiarsBlocks.ALOE_CAKE.get(), new Item.Properties().tab(ItemGroup.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PASSIONFRUIT_ICE_CREAM = ATMOSPHERIC.createItem("passionfruit_ice_cream", () -> new SoupItem(new Item.Properties().food(Foods.PASSIONFRUIT_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> PASSIONFRUIT_MILKSHAKE = ATMOSPHERIC.createItem("passionfruit_milkshake", () -> new PeculiarsMilkshakeItem(new Item.Properties().food(Foods.PASSIONFRUIT_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> PASSIONFRUIT_CAKE = ATMOSPHERIC.createItem("passionfruit_cake", () -> new BlockItem(PeculiarsBlocks.PASSIONFRUIT_CAKE.get(), new Item.Properties().tab(ItemGroup.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> TROPICAL_SALAD = ATMOSPHERIC.createItem("tropical_salad", () -> new SoupItem(new Item.Properties().food(Foods.TROPICAL_SALAD).craftRemainder(Items.BOWL).stacksTo(1).tab(ItemGroup.TAB_FOOD)));

    static class Foods {
        public static final Food YUCCA_ICE_CREAM = (new Food.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new EffectInstance(AtmosphericEffects.PERSISTENCE.get(), 600, 2), 1.0F).build();
        public static final Food YUCCA_MILKSHAKE = (new Food.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final Food YUCCA_FUDGE = (new Food.Builder()).nutrition(3).saturationMod(1.0F).effect(() -> new EffectInstance(AtmosphericEffects.PERSISTENCE.get(), 160, 1), 1.0F).effect(() -> new EffectInstance(NeapolitanEffects.SUGAR_RUSH.get(), 160, 1), 1.0F).build();
        public static final Food YUCCA_CAKE = (new Food.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new EffectInstance(AtmosphericEffects.PERSISTENCE.get(), 200), 1.0F).build();

        public static final Food ALOE_ICE_CREAM = (new Food.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new EffectInstance(AtmosphericEffects.RELIEF.get(), 800, 2), 1.0F).build();
        public static final Food ALOE_MILKSHAKE = (new Food.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final Food ALOE_JELLY_SLICE = (new Food.Builder()).nutrition(4).saturationMod(0.8F).effect(() -> new EffectInstance(AtmosphericEffects.RELIEF.get(), 400, 1), 1.0F).build();
        public static final Food ALOE_BERRY_SMOOTHIE = (new Food.Builder()).nutrition(3).saturationMod(0.6F).effect(() -> new EffectInstance(AtmosphericEffects.RELIEF.get(), 600), 1.0F).build();
        public static final Food ALOE_CAKE = (new Food.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new EffectInstance(AtmosphericEffects.RELIEF.get(), 200), 1.0F).build();

        public static final Food PASSIONFRUIT_ICE_CREAM = (new Food.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new EffectInstance(AtmosphericEffects.SPITTING.get(), 100, 2), 1.0F).build();
        public static final Food PASSIONFRUIT_MILKSHAKE = (new Food.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final Food PASSIONFRUIT_CAKE = (new Food.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new EffectInstance(AtmosphericEffects.SPITTING.get(), 100), 1.0F).build();

        public static final Food TROPICAL_SALAD = (new Food.Builder()).nutrition(6).saturationMod(1.1F).effect(() -> new EffectInstance(AtmosphericEffects.SPITTING.get(), 100), 1.0F).effect(() -> new EffectInstance(AtmosphericEffects.PERSISTENCE.get(), 200, 1), 1.0F).effect(() -> new EffectInstance(AtmosphericEffects.RELIEF.get(), 400, 1), 1.0F).build();

        public static final Food PASSIONFRUIT_TART = (new Food.Builder()).nutrition(4).saturationMod(0.6F).effect(() -> new EffectInstance(AtmosphericEffects.SPITTING.get(), 100, 0), 1.0F).build();
    }
}
