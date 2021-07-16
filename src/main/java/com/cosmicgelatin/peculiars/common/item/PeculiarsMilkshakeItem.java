package com.cosmicgelatin.peculiars.common.item;

import com.cosmicgelatin.peculiars.core.other.PeculiarsEvents;
import com.cosmicgelatin.peculiars.core.registry.PeculiarsItems;
import com.google.common.collect.ImmutableList;
import com.minecraftabnormals.atmospheric.core.registry.AtmosphericEffects;
import com.minecraftabnormals.neapolitan.common.item.DrinkItem;
import com.minecraftabnormals.neapolitan.core.registry.NeapolitanEffects;
import com.minecraftabnormals.upgrade_aquatic.core.registry.UAEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.ArrayList;

public class PeculiarsMilkshakeItem extends DrinkItem {

    public PeculiarsMilkshakeItem(Properties builder) {
        super(builder);
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entity) {
        this.handleEffects(entity);
        return super.onItemUseFinish(stack, worldIn, entity);
    }

    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (entity.world.isRemote) {
            return ActionResultType.PASS;
        } else {
            entity.world.playSound((PlayerEntity)null, entity.getPosition(), SoundEvents.ENTITY_WANDERING_TRADER_DRINK_MILK, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            if (player instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)player;
                CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
                serverplayerentity.addStat(Stats.ITEM_USED.get(this));
            }

            if (entity.getActivePotionEffect((Effect) NeapolitanEffects.VANILLA_SCENT.get()) == null) {
                this.handleEffects(entity);
            }

            if (!player.abilities.isCreativeMode) {
                stack.shrink(1);
                ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
                if (!player.inventory.addItemStackToInventory(itemstack)) {
                    player.dropItem(itemstack, false);
                }
            }

            return ActionResultType.SUCCESS;
        }
    }

    private void handleEffects(LivingEntity user) {
        ImmutableList<EffectInstance> effects = ImmutableList.copyOf(user.getActivePotionEffects());

        if (!effects.isEmpty()) {
            if (this == PeculiarsItems.ALOE_MILKSHAKE.get()) {
                for (EffectInstance e : effects) {
                    user.removePotionEffect(e.getPotion());
                }
                PeculiarsEvents.getAloeShaked().put(user.getUniqueID(), effects);
            } else if (this == PeculiarsItems.PASSIONFRUIT_MILKSHAKE.get()) {
                for (EffectInstance e : effects) {
                    user.removePotionEffect(e.getPotion());
                }
                PeculiarsEvents.getPassionShaked().put(user.getUniqueID(), effects);
            } else if (this == PeculiarsItems.YUCCA_MILKSHAKE.get()) {
                for (EffectInstance e : effects) {
                    user.removePotionEffect(e.getPotion());
                }
                PeculiarsEvents.getYuccaShaked().put(user.getUniqueID(), effects);
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

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public SoundEvent getDrinkSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }
}