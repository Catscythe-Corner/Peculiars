package com.cosmicgelatin.peculiars.core;

import com.minecraftabnormals.abnormals_core.core.annotations.ConfigKey;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class PeculiarsConfig {
    public static class Common {
        @ConfigKey("enable_atmospheric_food")
        public final ForgeConfigSpec.ConfigValue<Boolean> enableAtmosphericFood;
        @ConfigKey("disable_sorbet")
        public final ForgeConfigSpec.ConfigValue<Boolean> disableSorbet;
        @ConfigKey("tart_spitting")
        public final ForgeConfigSpec.ConfigValue<Boolean> tartSpitting;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("atmospheric");
            this.enableAtmosphericFood = builder.comment("If Atmospheric-flavored foods' recipes are enabled; defaults to true").define("EnableAtmosphericFood", true);
            this.disableSorbet = builder.comment("If passionfruit sorbet recipe is disabled; defaults to true").define("DisableSorbet", true);
            this.tartSpitting = builder.comment("If passionfruit tart gives spitting effect; defaults to true").define("TartSpitting", true);
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}