package com.cosmicgelatin.peculiars.core.registry;

import com.cosmicgelatin.peculiars.common.item.PeculiarsMilkshakeItem;
import com.cosmicgelatin.peculiars.core.Peculiars;
import com.teamabnormals.atmospheric.core.registry.AtmosphericMobEffects;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamabnormals.neapolitan.common.item.HealingDrinkItem;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Peculiars.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PeculiarsItems {
    public static final ItemSubRegistryHelper HELPER = Peculiars.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> YUCCA_ICE_CREAM = HELPER.createItem("yucca_ice_cream", () -> new BowlFoodItem(new Item.Properties().food(Foods.YUCCA_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> YUCCA_MILKSHAKE = HELPER.createItem("yucca_milkshake", () -> new PeculiarsMilkshakeItem(new Item.Properties().food(Foods.YUCCA_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> YUCCA_FUDGE = HELPER.createItem("yucca_fudge", () -> new Item(new Item.Properties().food(Foods.YUCCA_FUDGE).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> YUCCA_CAKE = HELPER.createItem("yucca_cake", () -> new BlockItem(PeculiarsBlocks.YUCCA_CAKE.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> ALOE_ICE_CREAM = HELPER.createItem("aloe_ice_cream", () -> new BowlFoodItem(new Item.Properties().food(Foods.ALOE_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> ALOE_MILKSHAKE = HELPER.createItem("aloe_milkshake", () -> new PeculiarsMilkshakeItem(new Item.Properties().food(Foods.ALOE_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> ALOE_JELLY_SLICE = HELPER.createItem("aloe_jelly_slice", () -> new Item(new Item.Properties().food(Foods.ALOE_JELLY_SLICE).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> ALOE_BERRY_SMOOTHIE = HELPER.createItem("aloe_berry_smoothie", () -> new HealingDrinkItem(2.0F, new Item.Properties().food(Foods.ALOE_BERRY_SMOOTHIE).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> ALOE_CAKE = HELPER.createItem("aloe_cake", () -> new BlockItem(PeculiarsBlocks.ALOE_CAKE.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PASSIONFRUIT_ICE_CREAM = HELPER.createItem("passionfruit_ice_cream", () -> new BowlFoodItem(new Item.Properties().food(Foods.PASSIONFRUIT_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> PASSIONFRUIT_MILKSHAKE = HELPER.createItem("passionfruit_milkshake", () -> new PeculiarsMilkshakeItem(new Item.Properties().food(Foods.PASSIONFRUIT_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> PASSIONFRUIT_CAKE = HELPER.createItem("passionfruit_cake", () -> new BlockItem(PeculiarsBlocks.PASSIONFRUIT_CAKE.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> TROPICAL_SALAD = HELPER.createItem("tropical_salad", () -> new BowlFoodItem(new Item.Properties().food(Foods.TROPICAL_SALAD).craftRemainder(Items.BOWL).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));

    static class Foods {
        public static final FoodProperties YUCCA_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.PERSISTENCE.get(), 600, 2), 1.0F).build();
        public static final FoodProperties YUCCA_MILKSHAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final FoodProperties YUCCA_FUDGE = (new FoodProperties.Builder()).nutrition(3).saturationMod(1.0F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.PERSISTENCE.get(), 160, 1), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 160, 1), 1.0F).build();
        public static final FoodProperties YUCCA_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.PERSISTENCE.get(), 200), 1.0F).build();

        public static final FoodProperties ALOE_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.RELIEF.get(), 800, 2), 1.0F).build();
        public static final FoodProperties ALOE_MILKSHAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final FoodProperties ALOE_JELLY_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.8F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.RELIEF.get(), 400, 1), 1.0F).build();
        public static final FoodProperties ALOE_BERRY_SMOOTHIE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.RELIEF.get(), 600), 1.0F).build();
        public static final FoodProperties ALOE_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.RELIEF.get(), 200), 1.0F).build();

        public static final FoodProperties PASSIONFRUIT_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.SPITTING.get(), 100, 2), 1.0F).build();
        public static final FoodProperties PASSIONFRUIT_MILKSHAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final FoodProperties PASSIONFRUIT_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.SPITTING.get(), 100), 1.0F).build();

        public static final FoodProperties TROPICAL_SALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.1F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.SPITTING.get(), 100), 1.0F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.PERSISTENCE.get(), 200, 1), 1.0F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.RELIEF.get(), 400, 1), 1.0F).build();

        public static final FoodProperties PASSIONFRUIT_TART = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.SPITTING.get(), 100, 0), 1.0F).build();
    }
}
