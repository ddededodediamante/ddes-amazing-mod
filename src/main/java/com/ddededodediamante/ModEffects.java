package com.ddededodediamante;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static class LongArmsEffect extends StatusEffect {
        protected LongArmsEffect() {
            super(StatusEffectCategory.BENEFICIAL, 0x98D982);

            this.addAttributeModifier(
                    EntityAttributes.BLOCK_INTERACTION_RANGE,
                    Identifier.of(ddesamazingmodMod.MOD_ID, "long_arms_block_reach"),
                    2,
                    EntityAttributeModifier.Operation.ADD_VALUE);

            this.addAttributeModifier(
                    EntityAttributes.ENTITY_INTERACTION_RANGE,
                    Identifier.of(ddesamazingmodMod.MOD_ID, "long_arms_entity_reach"),
                    2,
                    EntityAttributeModifier.Operation.ADD_VALUE);
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return false;
        }
    }

    public static class GiantEffect extends StatusEffect {
        protected GiantEffect() {
            super(StatusEffectCategory.NEUTRAL, 0x98D982);

            this.addAttributeModifier(
                    EntityAttributes.SCALE,
                    Identifier.of(ddesamazingmodMod.MOD_ID, "giant_scale"),
                    0.2,
                    EntityAttributeModifier.Operation.ADD_VALUE);
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return false;
        }
    }

    public static final RegistryEntry<StatusEffect> LONG_ARMS = Registry.registerReference(
            Registries.STATUS_EFFECT,
            Identifier.of(ddesamazingmodMod.MOD_ID, "long_arms"),
            new LongArmsEffect());

    public static final RegistryEntry<StatusEffect> GIANT = Registry.registerReference(
            Registries.STATUS_EFFECT,
            Identifier.of(ddesamazingmodMod.MOD_ID, "giant"),
            new GiantEffect());

    public static void initialize() {
    }
}
