package com.cosmicgelatin.peculiars.core.data.server.modifier;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsItems;
import com.teamabnormals.blueprint.common.advancement.modification.AdvancementModifierProvider;
import com.teamabnormals.blueprint.common.advancement.modification.modifiers.CriteriaModifier;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;

public class PeculiarsAdvancementModifierProvider extends AdvancementModifierProvider {

    public PeculiarsAdvancementModifierProvider(DataGenerator dataGenerator) {
        super(dataGenerator, Peculiars.MODID);
    }

    @Override
    protected void registerEntries() {
        CriteriaModifier.Builder constructBalancedDiet = CriteriaModifier.builder(this.modId);
        Collection<RegistryObject<Item>> items = PeculiarsItems.HELPER.getDeferredRegister().getEntries();

        items.forEach((item) -> {
            if (item.get().isEdible()) {
                constructBalancedDiet.addCriterion(ForgeRegistries.ITEMS.getKey(item.get()).getPath(), ConsumeItemTrigger.TriggerInstance.usedItem(item.get()));
            }
        });

        this.entry("husbandry/balanced_diet").selects("husbandry/balanced_diet").addModifier(constructBalancedDiet.requirements(RequirementsStrategy.AND).build());
    }
}
