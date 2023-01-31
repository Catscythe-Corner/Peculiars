package com.cosmicgelatin.peculiars.core;

import com.cosmicgelatin.peculiars.core.other.PeculiarsCompat;
import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Peculiars.MODID)
@Mod.EventBusSubscriber(modid = Peculiars.MODID)
public class Peculiars {
    public static final String MODID = "peculiars";
    public static boolean ATMOSPHERIC;
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    public static ResourceLocation modPrefix(String path) {
        return new ResourceLocation(Peculiars.MODID, path);
    }

    public Peculiars() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        ATMOSPHERIC = ModList.get().isLoaded("atmospheric");
        REGISTRY_HELPER.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PeculiarsConfig.COMMON_SPEC);
        modEventBus.addGenericListener(Block.class, this::registerConfigConditions);
        modEventBus.addListener(this::setupCommon);
    }

    private void registerConfigConditions(RegistryEvent.Register<Block> event) {
        DataUtil.registerConfigCondition(Peculiars.MODID, PeculiarsConfig.COMMON);
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            if (ATMOSPHERIC) {
                PeculiarsCompat.registerCompostables();
            }
        });
    }
}
