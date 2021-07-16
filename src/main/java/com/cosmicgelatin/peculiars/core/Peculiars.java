package com.cosmicgelatin.peculiars.core;

import com.cosmicgelatin.peculiars.core.other.PeculiarsCompat;
import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Peculiars.MODID)
@Mod.EventBusSubscriber(modid = Peculiars.MODID)
public class Peculiars {
    public static final String MODID = "peculiars";
    public static boolean ATMOSPHERIC;
    public static final RegistryHelper REGISTRY_ATMOSPHERIC = new RegistryHelper(MODID);

    public Peculiars() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PeculiarsConfig.COMMON_SPEC);
        ATMOSPHERIC = ModList.get().isLoaded("atmospheric");
        DataUtil.registerConfigCondition(Peculiars.MODID, PeculiarsConfig.COMMON);

        if (ATMOSPHERIC) {
            REGISTRY_ATMOSPHERIC.register(modEventBus);
        }

        modEventBus.addListener(this::setupCommon);
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            if (ATMOSPHERIC) {
                PeculiarsCompat.registerCompostables();
            }
        });
    }
}
