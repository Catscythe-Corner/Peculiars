package com.cosmicgelatin.peculiars.core.registry;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.cosmicgelatin.peculiars.core.PeculiarsConfig;
import com.teamabnormals.blueprint.core.util.DataUtil;
import net.minecraft.core.Registry;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PeculiarsLootConditions {

    public static final DeferredRegister<LootItemConditionType> LOOT_ITEM_CONDITION_TYPE = DeferredRegister.create(Registry.LOOT_ITEM_REGISTRY, Peculiars.MODID);

    public static final RegistryObject<LootItemConditionType> CONFIG = LOOT_ITEM_CONDITION_TYPE.register("config", () -> DataUtil.registerConfigCondition(Peculiars.MODID, PeculiarsConfig.COMMON));
}
