package com.cosmicgelatin.peculiars.core.other;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.cosmicgelatin.peculiars.core.PeculiarsConfig;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsItems;
import com.google.common.collect.ImmutableList;
import com.teamabnormals.atmospheric.core.registry.AtmosphericItems;
import com.teamabnormals.atmospheric.core.registry.AtmosphericMobEffects;
import com.teamabnormals.blueprint.core.util.TradeUtil;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = Peculiars.MODID)
public class PeculiarsEvents {
    private static final HashMap<UUID, ImmutableList<MobEffectInstance>> yuccaShaked = new HashMap<>();
    private static final HashMap<UUID, ImmutableList<MobEffectInstance>> aloeShaked = new HashMap<>();
    private static final HashMap<UUID, ImmutableList<MobEffectInstance>> passionShaked = new HashMap<>();

    @SubscribeEvent
    public static void onEntityAttacked(LivingDamageEvent event) {
        LivingEntity entity = event.getEntityLiving();

        if (Peculiars.ATMOSPHERIC && event.getSource().getDirectEntity() instanceof LivingEntity) {
            LivingEntity source = (LivingEntity)event.getSource().getDirectEntity();
            if (yuccaShaked.containsKey(entity.getUUID())) {
                ImmutableList<MobEffectInstance> effects = yuccaShaked.get(entity.getUUID());
                for (MobEffectInstance e : effects) {
                    source.addEffect(e);
                }
                yuccaShaked.remove(entity.getUUID());
            }
            if (aloeShaked.containsKey(entity.getUUID())) {
                ImmutableList<MobEffectInstance> effects = aloeShaked.get(entity.getUUID());
                for (MobEffectInstance e : effects) {
                    entity.addEffect(e);
                }
                aloeShaked.remove(entity.getUUID());
            }
            if (passionShaked.containsKey(source.getUUID())) {
                ImmutableList<MobEffectInstance> effects = passionShaked.get(source.getUUID());
                for (MobEffectInstance e : effects) {
                    entity.addEffect(e);
                }
                passionShaked.remove(source.getUUID());
            }
        }
    }

    @SubscribeEvent
    public static void onTartEaten(LivingEntityUseItemEvent.Finish event) {
        if (Peculiars.ATMOSPHERIC && event.getItem().getItem() == AtmosphericItems.PASSIONFRUIT_TART.get() && PeculiarsConfig.COMMON.tartSpitting.get())
        {event.getEntityLiving().addEffect(new MobEffectInstance(AtmosphericMobEffects.SPITTING.get(), 100));}
    }

    public static HashMap<UUID, ImmutableList<MobEffectInstance>> getYuccaShaked() {
        return yuccaShaked;
    }

    public static HashMap<UUID, ImmutableList<MobEffectInstance>> getAloeShaked() {
        return aloeShaked;
    }

    public static HashMap<UUID, ImmutableList<MobEffectInstance>> getPassionShaked() {
        return passionShaked;
    }

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        VillagerProfession type = event.getType();

        if (type == VillagerProfession.FARMER) {
            if (Peculiars.ATMOSPHERIC) {
                TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT,
                        new TradeUtil.BlueprintTrade(3, PeculiarsItems.YUCCA_CAKE.get(), 1, 12, 15));
                TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT,
                        new TradeUtil.BlueprintTrade(3, PeculiarsItems.ALOE_CAKE.get(), 1, 12, 15));
                TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT,
                        new TradeUtil.BlueprintTrade(3, PeculiarsItems.PASSIONFRUIT_CAKE.get(), 1, 12, 15));
            }
        }
    }
}