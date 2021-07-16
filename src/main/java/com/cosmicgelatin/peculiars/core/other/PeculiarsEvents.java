package com.cosmicgelatin.peculiars.core.other;

import com.cosmicgelatin.peculiars.core.Peculiars;
import com.cosmicgelatin.peculiars.core.PeculiarsConfig;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsItems;
import com.google.common.collect.ImmutableList;
import com.minecraftabnormals.abnormals_core.core.util.TradeUtil;
import com.minecraftabnormals.atmospheric.core.registry.AtmosphericEffects;
import com.minecraftabnormals.atmospheric.core.registry.AtmosphericItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import java.util.HashMap;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = Peculiars.MODID)
public class PeculiarsEvents {
    private static final HashMap<UUID, ImmutableList<EffectInstance>> yuccaShaked = new HashMap<>();
    private static final HashMap<UUID, ImmutableList<EffectInstance>> aloeShaked = new HashMap<>();
    private static final HashMap<UUID, ImmutableList<EffectInstance>> passionShaked = new HashMap<>();

    @SubscribeEvent
    public static void onEntityAttacked(LivingDamageEvent event) {
        LivingEntity entity = event.getEntityLiving();

        if (Peculiars.ATMOSPHERIC && event.getSource().getImmediateSource() instanceof LivingEntity) {
            LivingEntity source = (LivingEntity)event.getSource().getImmediateSource();
            if (yuccaShaked.containsKey(entity.getUniqueID())) {
                ImmutableList<EffectInstance> effects = yuccaShaked.get(entity.getUniqueID());
                for (EffectInstance e : effects) {
                    source.addPotionEffect(e);
                }
                yuccaShaked.remove(entity.getUniqueID());
            }
            if (aloeShaked.containsKey(entity.getUniqueID())) {
                ImmutableList<EffectInstance> effects = aloeShaked.get(entity.getUniqueID());
                for (EffectInstance e : effects) {
                    entity.addPotionEffect(e);
                }
                aloeShaked.remove(entity.getUniqueID());
            }
            if (passionShaked.containsKey(source.getUniqueID())) {
                ImmutableList<EffectInstance> effects = passionShaked.get(source.getUniqueID());
                for (EffectInstance e : effects) {
                    entity.addPotionEffect(e);
                }
                passionShaked.remove(source.getUniqueID());
            }
        }
    }

    @SubscribeEvent
    public static void onTartEaten(LivingEntityUseItemEvent.Finish event) {
        if (Peculiars.ATMOSPHERIC && event.getItem().getItem() == AtmosphericItems.PASSIONFRUIT_TART.get() && PeculiarsConfig.COMMON.tartSpitting.get())
        {event.getEntityLiving().addPotionEffect(new EffectInstance(AtmosphericEffects.SPITTING.get(), 100));}
    }

    public static HashMap<UUID, ImmutableList<EffectInstance>> getYuccaShaked() {
        return yuccaShaked;
    }

    public static HashMap<UUID, ImmutableList<EffectInstance>> getAloeShaked() {
        return aloeShaked;
    }

    public static HashMap<UUID, ImmutableList<EffectInstance>> getPassionShaked() {
        return passionShaked;
    }

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        VillagerProfession type = event.getType();

        if (type == VillagerProfession.FARMER) {
            if (Peculiars.ATMOSPHERIC) {
                TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT,
                        new TradeUtil.AbnormalsTrade(3, PeculiarsItems.YUCCA_CAKE.get(), 1, 12, 15));
                TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT,
                        new TradeUtil.AbnormalsTrade(3, PeculiarsItems.ALOE_CAKE.get(), 1, 12, 15));
                TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT,
                        new TradeUtil.AbnormalsTrade(3, PeculiarsItems.PASSIONFRUIT_CAKE.get(), 1, 12, 15));
            }
        }
    }
}