package com.cosmicgelatin.peculiars.core.other;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsBlocks;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsItems;
import com.teamabnormals.blueprint.core.api.BlueprintCauldronInteraction;
import com.teamabnormals.neapolitan.core.NeapolitanConfig;
import com.teamabnormals.neapolitan.core.other.NeapolitanCauldronInteractions;
import net.minecraft.core.cauldron.CauldronInteraction;

public class PeculiarsCauldronInteractions {
    public static BlueprintCauldronInteraction YUCCA_MILKSHAKE = BlueprintCauldronInteraction.register(Peculiars.modPrefix("yucca_milkshake"), CauldronInteraction.newInteractionMap());
    public static BlueprintCauldronInteraction ALOE_MILKSHAKE = BlueprintCauldronInteraction.register(Peculiars.modPrefix("aloe_milkshake"), CauldronInteraction.newInteractionMap());
    public static BlueprintCauldronInteraction PASSIONFRUIT_MILKSHAKE = BlueprintCauldronInteraction.register(Peculiars.modPrefix("passionfruit_milkshake"), CauldronInteraction.newInteractionMap());

    public static void registerCauldronInteractions() {
        if (NeapolitanConfig.COMMON.milkshakeCauldrons.get()) {
            NeapolitanCauldronInteractions.addMilkshakeInteractions(PeculiarsItems.YUCCA_MILKSHAKE.get(), PeculiarsBlocks.YUCCA_MILKSHAKE_CAULDRON.get(), PeculiarsItems.YUCCA_ICE_CREAM.get(), YUCCA_MILKSHAKE.map());
            NeapolitanCauldronInteractions.addMilkshakeInteractions(PeculiarsItems.ALOE_MILKSHAKE.get(), PeculiarsBlocks.ALOE_MILKSHAKE_CAULDRON.get(), PeculiarsItems.ALOE_ICE_CREAM.get(), ALOE_MILKSHAKE.map());
            NeapolitanCauldronInteractions.addMilkshakeInteractions(PeculiarsItems.PASSIONFRUIT_MILKSHAKE.get(), PeculiarsBlocks.PASSIONFRUIT_MILKSHAKE_CAULDRON.get(), PeculiarsItems.PASSIONFRUIT_ICE_CREAM.get(), PASSIONFRUIT_MILKSHAKE.map());
        }
    }
}
