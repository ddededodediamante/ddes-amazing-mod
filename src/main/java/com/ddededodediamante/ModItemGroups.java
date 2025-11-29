package com.ddededodediamante;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> DDES_ITEM_GROUP_KEY = RegistryKey.of(
        Registries.ITEM_GROUP.getKey(),
        Identifier.of(ddesamazingmodMod.MOD_ID, "item_group")
    );

    public static final ItemGroup DDES_ITEM_GROUP = FabricItemGroup.builder()
        .icon(() -> new ItemStack(ModBlocks.COOL_BLOCK.asItem()))
        .displayName(Text.translatable("itemGroup.ddesamazingmod"))
        .build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, DDES_ITEM_GROUP_KEY, DDES_ITEM_GROUP);
    }
}
