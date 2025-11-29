package com.ddededodediamante;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final Potion LONG_ARMS_POTION = Registry.register(
            Registries.POTION,
            Identifier.of(ddesamazingmodMod.MOD_ID, "long_arms"),
            new Potion("long_arms",
                    new StatusEffectInstance(
                            ModEffects.LONG_ARMS,
                            3600,
                            0)));

    public static final Potion GIANT_POTION = Registry.register(
            Registries.POTION,
            Identifier.of(ddesamazingmodMod.MOD_ID, "giant"),
            new Potion("giant",
                    new StatusEffectInstance(
                            ModEffects.GIANT,
                            3600,
                            0)));

    public static void initialize() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.LEAPING,
                    Items.STONE,
                    Registries.POTION.getEntry(LONG_ARMS_POTION));
            builder.registerPotionRecipe(
                    Potions.LEAPING,
                    Items.BEEF,
                    Registries.POTION.getEntry(GIANT_POTION));
        });
    }
}
