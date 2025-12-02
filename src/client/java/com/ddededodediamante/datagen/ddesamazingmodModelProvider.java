package com.ddededodediamante.datagen;

import com.ddededodediamante.ModBlocks;
import com.ddededodediamante.ModItems;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.data.family.BlockFamily;

public class ddesamazingmodModelProvider extends FabricModelProvider {
    public ddesamazingmodModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockFamily POOP_FAMILY = new BlockFamily.Builder(ModBlocks.POOP_BLOCK)
                .stairs(ModBlocks.POOP_STAIRS)
                .slab(ModBlocks.POOP_SLAB)
                .fence(ModBlocks.POOP_FENCE)
                .fenceGate(ModBlocks.POOP_FENCE_GATE)
                .pressurePlate(ModBlocks.POOP_PRESSURE_PLATE)
                .button(ModBlocks.POOP_BUTTON)
                .door(ModBlocks.POOP_DOOR)
                .wall(ModBlocks.POOP_WALL)
                .build();

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POOP_BLOCK).family(POOP_FAMILY);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COOL_BLOCK)
                .stairs(ModBlocks.COOL_STAIRS)
                .slab(ModBlocks.COOL_SLAB);

        blockStateModelGenerator.registerSimpleState(ModBlocks.DIE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SUSPICIOUS_SUBSTANCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORD_LAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SKIBIDI_PENGUINMOD_SONG_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYSTAL_CAVE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAKETOWN_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.DAY_WAND, Models.HANDHELD_ROD);
        itemModelGenerator.register(ModItems.NIGHT_WAND, Models.HANDHELD_ROD);
        itemModelGenerator.register(ModItems.POOP_PIECE, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.SUSPICIOUS_CAKE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.ANTI_COOKED_BEEF, Models.GENERATED);
        itemModelGenerator.register(ModItems.EVIL_STICK, Models.HANDHELD_ROD);
    }

    @Override
    public String getName() {
        return "ddesamazingmodModelProvider";
    }
}
