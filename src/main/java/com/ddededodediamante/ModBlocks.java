package com.ddededodediamante;

import java.lang.reflect.Field;
import java.util.function.Function;

import com.ddededodediamante.block.custom.DieBlock;
import com.ddededodediamante.block.custom.SuspiciousCake;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block COOL_BLOCK = register(
            "cool_block",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(2.0f),
            true);
    public static final Block COOL_STAIRS = register(
            "cool_stairs",
            settings -> new StairsBlock(COOL_BLOCK.getDefaultState(), settings),
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(2.0f),
            true);
    public static final Block COOL_SLAB = register(
            "cool_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(2.0f),
            true);

    public static final Block POOP_BLOCK = register(
            "poop_block",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WET_GRASS).strength(1.0f),
            true);
    public static final Block POOP_STAIRS = register(
            "poop_stairs",
            settings -> new StairsBlock(POOP_BLOCK.getDefaultState(), settings),
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WET_GRASS).strength(1.0f),
            true);
    public static final Block POOP_SLAB = register(
            "poop_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WET_GRASS).strength(1.0f),
            true);
    public static final Block POOP_WALL = register(
            "poop_wall",
            WallBlock::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WET_GRASS).strength(1.0f),
            true);
    public static final Block POOP_FENCE = register(
            "poop_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WET_GRASS)
                    .strength(1.0f),
            true);
    public static final Block POOP_FENCE_GATE = register(
            "poop_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WET_GRASS)
                    .strength(1.0f),
            true);
    public static final Block POOP_BUTTON = register(
            "poop_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5f),
            true);
    public static final Block POOP_DOOR = register(
            "poop_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .strength(1.0f)
                    .sounds(BlockSoundGroup.WET_GRASS)
                    .nonOpaque(),
            true);
    public static final Block POOP_PRESSURE_PLATE = register(
            "poop_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.WET_GRASS),
            true);

    public static final Block DIE = register(
            "die",
            settings -> new DieBlock(settings),
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.IRON).strength(3.0f),
            true);

    public static final Block SUSPICIOUS_CAKE = register(
            "suspicious_cake",
            SuspiciousCake::new,
            Block.Settings.copy(Blocks.CAKE).sounds(BlockSoundGroup.LARGE_AMETHYST_BUD),
            new Item.Settings().maxCount(1));

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
            itemGroup.add(ModBlocks.COOL_BLOCK.asItem());
            itemGroup.add(ModBlocks.COOL_STAIRS.asItem());
            itemGroup.add(ModBlocks.COOL_SLAB.asItem());
            itemGroup.add(ModBlocks.POOP_BLOCK.asItem());
            itemGroup.add(ModBlocks.POOP_STAIRS.asItem());
            itemGroup.add(ModBlocks.POOP_SLAB.asItem());
            itemGroup.add(ModBlocks.POOP_WALL.asItem());
            itemGroup.add(ModBlocks.POOP_FENCE.asItem());
            itemGroup.add(ModBlocks.POOP_FENCE_GATE.asItem());
            itemGroup.add(ModBlocks.POOP_DOOR.asItem());
            itemGroup.add(ModBlocks.POOP_BUTTON.asItem());
            itemGroup.add(ModBlocks.POOP_PRESSURE_PLATE.asItem());
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(itemGroup -> {
            itemGroup.add(ModBlocks.DIE.asItem());
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> {
            itemGroup.add(ModBlocks.SUSPICIOUS_CAKE.asItem());
        });

        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.DDES_ITEM_GROUP_KEY).register((itemGroup) -> {
            for (Field field : ModBlocks.class.getDeclaredFields()) {
                try {
                    Object value = field.get(null);
                    if (value instanceof Block block) {
                        Item item = block.asItem();
                        if (item != Items.AIR) {
                            itemGroup.add(item);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static Block register(
            String name,
            Function<AbstractBlock.Settings, Block> blockFactory,
            AbstractBlock.Settings settings,
            Item.Settings itemSettings) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (itemSettings != null) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block,
                    itemSettings.registryKey(itemKey).useBlockPrefixedTranslationKey());

            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static Block register(
            String name,
            Function<AbstractBlock.Settings, Block> blockFactory,
            AbstractBlock.Settings settings,
            boolean shouldRegisterItem) {
        return register(
                name,
                blockFactory,
                settings,
                shouldRegisterItem ? new Item.Settings() : null);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ddesamazingmodMod.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ddesamazingmodMod.MOD_ID, name));
    }
}