package com.cosmicgelatin.peculiars.common.item;

import com.cosmicgelatin.peculiars.core.other.PeculiarsEvents;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsItems;
import com.google.common.collect.ImmutableList;
import com.teamabnormals.neapolitan.common.item.DrinkItem;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class PeculiarsMilkshakeItem extends DrinkItem {

    public PeculiarsMilkshakeItem(Properties builder) {
        super(builder);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entity) {
        this.handleEffects(entity);
        return super.finishUsingItem(stack, worldIn, entity);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (entity.level.isClientSide) {
            return InteractionResult.PASS;
        } else {
            entity.level.playSound((Player) null, entity.blockPosition(), SoundEvents.WANDERING_TRADER_DRINK_MILK, SoundSource.NEUTRAL, 1.0F, 1.0F);
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
                serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            }

            if (entity.getEffect(NeapolitanMobEffects.VANILLA_SCENT.get()) == null) {
                this.handleEffects(entity);
            }

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
                ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
                if (!player.getInventory().add(itemstack)) {
                    player.drop(itemstack, false);
                }
            }

            return InteractionResult.SUCCESS;
        }
    }

    private void handleEffects(LivingEntity user) {
        ImmutableList<MobEffectInstance> effects = ImmutableList.copyOf(user.getActiveEffects());

        if (!effects.isEmpty()) {
            if (this == PeculiarsItems.ALOE_MILKSHAKE.get()) {
                for (MobEffectInstance e : effects) {
                    user.removeEffect(e.getEffect());
                }
                PeculiarsEvents.getAloeShaked().put(user.getUUID(), effects);
            } else if (this == PeculiarsItems.PASSIONFRUIT_MILKSHAKE.get()) {
                for (MobEffectInstance e : effects) {
                    user.removeEffect(e.getEffect());
                }
                PeculiarsEvents.getPassionShaked().put(user.getUUID(), effects);
            } else if (this == PeculiarsItems.YUCCA_MILKSHAKE.get()) {
                for (MobEffectInstance e : effects) {
                    user.removeEffect(e.getEffect());
                }
                PeculiarsEvents.getYuccaShaked().put(user.getUUID(), effects);
            }
        }
        /**ArrayList<EffectInstance> newEffects = new ArrayList<EffectInstance>();
         for (EffectInstance e : effects) {
         EffectInstance newEff;
         switch (e.getEffectName()) {
         case "effect.minecraft.regeneration":
         newEff = new EffectInstance(Effects.WITHER, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.strength":
         newEff = new EffectInstance(Effects.WEAKNESS, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.speed":
         newEff = new EffectInstance(Effects.SLOWNESS, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.haste":
         newEff = new EffectInstance(Effects.MINING_FATIGUE, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.night_vision":
         newEff = new EffectInstance(Effects.BLINDNESS, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.invisibility":
         newEff = new EffectInstance(Effects.GLOWING, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.slow_falling":
         newEff = new EffectInstance(Effects.LEVITATION, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.luck":
         newEff = new EffectInstance(Effects.UNLUCK, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.hero_of_the_village":
         newEff = new EffectInstance(Effects.BAD_OMEN, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.wither":
         newEff = new EffectInstance(Effects.REGENERATION, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.weakness":
         newEff = new EffectInstance(Effects.STRENGTH, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.slowness":
         newEff = new EffectInstance(Effects.SPEED, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.mining_fatigue":
         newEff = new EffectInstance(Effects.HASTE, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.blindness":
         newEff = new EffectInstance(Effects.NIGHT_VISION, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.glowing":
         newEff = new EffectInstance(Effects.INVISIBILITY, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.levitation":
         newEff = new EffectInstance(Effects.SLOW_FALLING, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.unluck":
         newEff = new EffectInstance(Effects.LUCK, e.getDuration(), e.getAmplifier());
         break;
         case "effect.minecraft.bad_omen":
         newEff = new EffectInstance(Effects.HERO_OF_THE_VILLAGE, e.getDuration(), e.getAmplifier());
         break;
         case "effect.atmospheric.relief":
         newEff = new EffectInstance(AtmosphericEffects.WORSENING.get(), e.getDuration(), e.getAmplifier());
         break;
         case "effect.upgrade_aquatic.vibing":
         newEff = new EffectInstance(UAEffects.REPELLENCE.get(), e.getDuration(), e.getAmplifier());
         break;
         case "effect.atmospheric.worsening":
         newEff = new EffectInstance(AtmosphericEffects.RELIEF.get(), e.getDuration(), e.getAmplifier());
         break;
         case "effect.upgrade_aquatic.repellence":
         newEff = new EffectInstance(UAEffects.VIBING.get(), e.getDuration(), e.getAmplifier());
         break;
         default:
         newEff = e;
         break;
         }
         entity.removePotionEffect(e.getPotion());
         newEffects.add(newEff);
         }
         for (EffectInstance e : newEffects) {entity.addPotionEffect(e);}*/
    }

    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }
}