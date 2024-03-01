package com.cosmicgelatin.peculiars.core.registry;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.teamabnormals.atmospheric.core.Atmospheric;
import com.teamabnormals.atmospheric.core.registry.AtmosphericMobEffects;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamabnormals.neapolitan.common.item.HealingDrinkItem;
import com.teamabnormals.neapolitan.common.item.IceCreamItem;
import com.teamabnormals.neapolitan.common.item.MilkshakeItem;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Peculiars.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PeculiarsItems {
    public static final ItemSubRegistryHelper HELPER = Peculiars.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> YUCCA_ICE_CREAM = HELPER.createItem("yucca_ice_cream", () -> new IceCreamItem(withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).food(Foods.YUCCA_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final RegistryObject<Item> YUCCA_MILKSHAKE = HELPER.createItem("yucca_milkshake", () -> new MilkshakeItem(withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).food(Foods.YUCCA_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final RegistryObject<Item> YUCCA_FUDGE = HELPER.createItem("yucca_fudge", () -> new Item(withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).food(Foods.YUCCA_FUDGE)));
    public static final RegistryObject<Item> YUCCA_CAKE = HELPER.createItem("yucca_cake", () -> new BlockItem(PeculiarsBlocks.YUCCA_CAKE.get(), withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> ALOE_ICE_CREAM = HELPER.createItem("aloe_ice_cream", () -> new IceCreamItem(withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).food(Foods.ALOE_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final RegistryObject<Item> ALOE_MILKSHAKE = HELPER.createItem("aloe_milkshake", () -> new MilkshakeItem(withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).food(Foods.ALOE_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final RegistryObject<Item> ALOE_JELLY_SLICE = HELPER.createItem("aloe_jelly_slice", () -> new Item(withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).food(Foods.ALOE_JELLY_SLICE)));
    public static final RegistryObject<Item> ALOE_BERRY_SMOOTHIE = HELPER.createItem("aloe_berry_smoothie", () -> new HealingDrinkItem(2.0F, withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).food(Foods.ALOE_BERRY_SMOOTHIE).stacksTo(16)));
    public static final RegistryObject<Item> ALOE_CAKE = HELPER.createItem("aloe_cake", () -> new BlockItem(PeculiarsBlocks.ALOE_CAKE.get(), withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PASSIONFRUIT_ICE_CREAM = HELPER.createItem("passionfruit_ice_cream", () -> new IceCreamItem(withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).food(Foods.PASSIONFRUIT_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final RegistryObject<Item> PASSIONFRUIT_MILKSHAKE = HELPER.createItem("passionfruit_milkshake", () -> new MilkshakeItem(withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).food(Foods.PASSIONFRUIT_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final RegistryObject<Item> PASSIONFRUIT_CAKE = HELPER.createItem("passionfruit_cake", () -> new BlockItem(PeculiarsBlocks.PASSIONFRUIT_CAKE.get(), withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> TROPICAL_SALAD = HELPER.createItem("tropical_salad", () -> new BowlFoodItem(withOptionalTab(Atmospheric.MOD_ID, CreativeModeTab.TAB_FOOD).food(Foods.TROPICAL_SALAD).craftRemainder(Items.BOWL).stacksTo(1)));

    public static Item.Properties withOptionalTab(String modId, CreativeModeTab tab) {
        return ModList.get().isLoaded(modId) ? new Item.Properties().tab(tab) : new Item.Properties();
    }

    static class Foods {
        public static final FoodProperties YUCCA_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.PERSISTENCE.get(), 600, 2), 1.0F).build();
        public static final FoodProperties YUCCA_MILKSHAKE = NeapolitanItems.NeapolitanFoods.createMilkshake(() -> new MobEffectInstance(AtmosphericMobEffects.PERSISTENCE.get(), 700)).build();
        public static final FoodProperties YUCCA_FUDGE = (new FoodProperties.Builder()).nutrition(3).saturationMod(1.0F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.PERSISTENCE.get(), 160, 1), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 160, 1), 1.0F).build();
        public static final FoodProperties YUCCA_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.PERSISTENCE.get(), 200), 1.0F).build();

        public static final FoodProperties ALOE_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.RELIEF.get(), 800, 2), 1.0F).build();
        public static final FoodProperties ALOE_MILKSHAKE = NeapolitanItems.NeapolitanFoods.createMilkshake(() -> new MobEffectInstance(AtmosphericMobEffects.RELIEF.get(), 920)).build();
        public static final FoodProperties ALOE_JELLY_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.8F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.RELIEF.get(), 400, 1), 1.0F).build();
        public static final FoodProperties ALOE_BERRY_SMOOTHIE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.RELIEF.get(), 600), 1.0F).build();
        public static final FoodProperties ALOE_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.RELIEF.get(), 200), 1.0F).build();

        public static final FoodProperties PASSIONFRUIT_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.SPITTING.get(), 100, 2), 1.0F).build();
        public static final FoodProperties PASSIONFRUIT_MILKSHAKE = NeapolitanItems.NeapolitanFoods.createMilkshake(() -> new MobEffectInstance(AtmosphericMobEffects.SPITTING.get(), 200)).build();
        public static final FoodProperties PASSIONFRUIT_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.SPITTING.get(), 100), 1.0F).build();

        public static final FoodProperties TROPICAL_SALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.1F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.SPITTING.get(), 100), 1.0F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.PERSISTENCE.get(), 200, 1), 1.0F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.RELIEF.get(), 400, 1), 1.0F).build();

        public static final FoodProperties PASSIONFRUIT_TART = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(() -> new MobEffectInstance(AtmosphericMobEffects.SPITTING.get(), 100, 0), 1.0F).build();
    }
}
