package com.cosmicgelatin.peculiars.core;

import com.cosmicgelatin.peculiars.core.data.client.PeculiarsBlockStateProvider;
import com.cosmicgelatin.peculiars.core.data.server.modifier.PeculiarsAdvancementModifierProvider;
import com.cosmicgelatin.peculiars.core.data.server.tags.PeculiarsBlockTagsProvider;
import com.cosmicgelatin.peculiars.core.data.server.tags.PeculiarsItemTagsProvider;
import com.cosmicgelatin.peculiars.core.other.PeculiarsCauldronInteractions;
import com.cosmicgelatin.peculiars.core.other.PeculiarsCompat;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsLootConditions;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
        PeculiarsLootConditions.LOOT_ITEM_CONDITION_TYPE.register(modEventBus);

        modEventBus.addListener(this::setupCommon);
        modEventBus.addListener(this::gatherData);
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            if (ATMOSPHERIC) {
                PeculiarsCompat.registerCompostables();
                PeculiarsCauldronInteractions.registerCauldronInteractions();
            }
        });
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(includeClient, new PeculiarsBlockStateProvider(generator, fileHelper));

        PeculiarsBlockTagsProvider blockTagsProvider = new PeculiarsBlockTagsProvider(generator, fileHelper);
        generator.addProvider(includeServer, blockTagsProvider);
        generator.addProvider(includeServer, new PeculiarsItemTagsProvider(generator, blockTagsProvider, fileHelper));
        generator.addProvider(includeServer, new PeculiarsAdvancementModifierProvider(generator));
    }
}
