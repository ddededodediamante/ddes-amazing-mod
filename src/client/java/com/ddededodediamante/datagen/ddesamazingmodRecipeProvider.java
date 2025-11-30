package com.ddededodediamante.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.ddededodediamante.ModBlocks;
import com.ddededodediamante.ModItems;

import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class ddesamazingmodRecipeProvider extends FabricRecipeProvider {
    public ddesamazingmodRecipeProvider(FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup,
            RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                /* poop */

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_BLOCK.asItem(), 2)
                        .pattern("dd")
                        .pattern("dd")
                        .input('d', ItemTags.DIRT)
                        .criterion("has_dirt", conditionsFromTag(ItemTags.DIRT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_STAIRS.asItem(), 4)
                        .pattern("p  ")
                        .pattern("pp ")
                        .pattern("ppp")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_SLAB.asItem(), 6)
                        .pattern("ppp")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_WALL.asItem(), 6)
                        .pattern("ppp")
                        .pattern("ppp")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_FENCE.asItem(), 3)
                        .pattern("psp")
                        .pattern("psp")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .input('s', Items.STICK)
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_FENCE_GATE.asItem(), 1)
                        .pattern("sps")
                        .pattern("sps")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .input('s', Items.STICK)
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.REDSTONE, ModBlocks.POOP_BUTTON.asItem())
                        .input(ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, ModBlocks.POOP_PRESSURE_PLATE.asItem(), 1)
                        .pattern("pp")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, ModBlocks.POOP_DOOR.asItem(), 3)
                        .pattern("pp")
                        .pattern("pp")
                        .pattern("pp")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.FOOD, ModItems.POOP_PIECE, 2)
                        .pattern("p")
                        .input('p', ModBlocks.POOP_BLOCK.asItem())
                        .criterion("has_poop_block",
                                conditionsFromItem(ModBlocks.POOP_BLOCK.asItem()))
                        .offerTo(exporter);

                /* cool blocks */

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COOL_BLOCK.asItem(), 2)
                        .pattern("s")
                        .pattern("t")
                        .pattern("b")
                        .input('s', ModItems.SUSPICIOUS_SUBSTANCE)
                        .input('t', Items.COBBLESTONE)
                        .input('b', Items.BLUE_DYE)
                        .criterion("has_suspicious_substance",
                                conditionsFromItem(ModItems.SUSPICIOUS_SUBSTANCE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COOL_STAIRS.asItem(), 4)
                        .pattern("c  ")
                        .pattern("cc ")
                        .pattern("ccc")
                        .input('c', ModBlocks.COOL_BLOCK.asItem())
                        .criterion("has_cool_block",
                                conditionsFromItem(ModBlocks.COOL_BLOCK.asItem()))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COOL_SLAB.asItem(), 6)
                        .pattern("ccc")
                        .input('c', ModBlocks.COOL_BLOCK.asItem())
                        .criterion("has_cool_block",
                                conditionsFromItem(ModBlocks.COOL_BLOCK.asItem()))
                        .offerTo(exporter);

                /* others */

                createShaped(RecipeCategory.FOOD, ModBlocks.SUSPICIOUS_CAKE.asItem(), 1)
                        .pattern("mmm")
                        .pattern("sgs")
                        .pattern("www")
                        .input('m', Items.MILK_BUCKET)
                        .input('s', ModItems.SUSPICIOUS_SUBSTANCE)
                        .input('g', Items.EGG)
                        .input('w', Items.WHEAT)
                        .criterion("has_milk", conditionsFromItem(Items.MILK_BUCKET))
                        .criterion("has_suspicious",
                                conditionsFromItem(ModItems.SUSPICIOUS_SUBSTANCE))
                        .criterion("has_egg", conditionsFromItem(Items.EGG))
                        .criterion("has_wheat", conditionsFromItem(Items.WHEAT))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.FOOD, ModItems.ANTI_COOKED_BEEF, 1)
                        .input(Items.COOKED_BEEF)
                        .input(ModItems.SUSPICIOUS_SUBSTANCE)
                        .criterion("has_cooked_beef", conditionsFromItem(Items.COOKED_BEEF))
                        .criterion("has_suspicious",
                                conditionsFromItem(ModItems.SUSPICIOUS_SUBSTANCE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.DAY_WAND, 1)
                        .pattern("sds")
                        .pattern("gmg")
                        .pattern(" m ")
                        .input('s', ModItems.SUSPICIOUS_SUBSTANCE)
                        .input('d', Blocks.DAYLIGHT_DETECTOR.asItem())
                        .input('g', Items.GOLD_INGOT)
                        .input('m', Items.STICK)
                        .criterion("has_suspicious",
                                conditionsFromItem(ModItems.SUSPICIOUS_SUBSTANCE))
                        .criterion("has_daylight_detector",
                                conditionsFromItem(Blocks.DAYLIGHT_DETECTOR.asItem()))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.NIGHT_WAND, 1)
                        .pattern("sds")
                        .pattern("imi")
                        .pattern(" m ")
                        .input('s', ModItems.SUSPICIOUS_SUBSTANCE)
                        .input('d', Blocks.DAYLIGHT_DETECTOR.asItem())
                        .input('i', Items.IRON_INGOT)
                        .input('m', Items.STICK)
                        .criterion("has_suspicious",
                                conditionsFromItem(ModItems.SUSPICIOUS_SUBSTANCE))
                        .criterion("has_daylight_detector",
                                conditionsFromItem(Blocks.DAYLIGHT_DETECTOR.asItem()))
                        .offerTo(exporter);

                /* smelting */

                offerSmelting(
                        List.of(Items.AMETHYST_SHARD, Items.AMETHYST_BLOCK,
                                Items.AMETHYST_CLUSTER),
                        RecipeCategory.MISC,
                        ModItems.SUSPICIOUS_SUBSTANCE,
                        0.1f,
                        150,
                        "amethyst_to_suspicious_substance");
            }
        };
    }

    @Override
    public String getName() {
        return "ddesamazingmodRecipeProvider";
    }
}
