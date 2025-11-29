package com.ddededodediamante.block.entity;

import com.ddededodediamante.ModBlocks;
import com.ddededodediamante.ddesamazingmodMod;
import com.ddededodediamante.block.entity.custom.DieBlockEntity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<DieBlockEntity> DIE_BE = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ddesamazingmodMod.MOD_ID, "die_be"),
            FabricBlockEntityTypeBuilder.create(DieBlockEntity::new, ModBlocks.DIE).build());

    public static void initialize() {
    }
}
