package com.ddededodediamante;

import java.lang.reflect.Field;
import java.util.function.Function;

import com.ddededodediamante.item.AntiCookedBeef;
import com.ddededodediamante.item.DayWand;
import com.ddededodediamante.item.EvilStick;
import com.ddededodediamante.item.PoopPiece;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance", Item::new,
            new Item.Settings());

    public static final Item CORD_LAT = register("cord_lat", Item::new,
            new Item.Settings().food(
                    new FoodComponent.Builder().nutrition(5).saturationModifier(0.6f).build()));

    public static final Item SKIBIDI_PENGUINMOD_SONG_MUSIC_DISC = register("skibidi_penguinmod_song_music_disc",
            Item::new,
            new Item.Settings().jukeboxPlayable(ModSounds.SKIBIDI_PENGUINMOD_SONG_KEY).maxCount(1)
                    .rarity(Rarity.RARE));
    public static final Item CRYSTAL_CAVE_MUSIC_DISC = register("crystal_cave_music_disc",
            Item::new,
            new Item.Settings().jukeboxPlayable(ModSounds.CRYSTAL_CAVE_KEY).maxCount(1)
                    .rarity(Rarity.RARE));
    public static final Item CAKETOWN_MUSIC_DISC = register("caketown_music_disc",
            Item::new,
            new Item.Settings().jukeboxPlayable(ModSounds.CAKETOWN_KEY).maxCount(1)
                    .rarity(Rarity.RARE));

    public static final Item DAY_WAND = register("day_wand", DayWand::new,
            new Item.Settings().maxCount(1));

    public static final Item POOP_PIECE = register("poop_piece", PoopPiece::new,
            new Item.Settings().food(
                    new FoodComponent.Builder().nutrition(1).saturationModifier(0.2f).build()));

    public static final Item ANTI_COOKED_BEEF = register(
            "anti_cooked_beef", AntiCookedBeef::new,
            new Item.Settings()
                    .food(new FoodComponent.Builder()
                            .nutrition(0)
                            .saturationModifier(0f)
                            .alwaysEdible()
                            .build()));

    public static final Item EVIL_STICK = register("evil_stick", EvilStick::new,
            new Item.Settings().maxCount(1));

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.CORD_LAT);
                    itemGroup.add(ModItems.POOP_PIECE);
                    itemGroup.add(ModItems.ANTI_COOKED_BEEF);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.DAY_WAND);
                    itemGroup.add(ModItems.SKIBIDI_PENGUINMOD_SONG_MUSIC_DISC);
                    itemGroup.add(ModItems.CRYSTAL_CAVE_MUSIC_DISC);
                    itemGroup.add(ModItems.CAKETOWN_MUSIC_DISC);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> {
            itemGroup.add(ModItems.EVIL_STICK);
        });

        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.DDES_ITEM_GROUP_KEY).register((itemGroup) -> {
            for (Field field : ModItems.class.getDeclaredFields()) {
                try {
                    Object value = field.get(null);
                    if (value instanceof Item item) {
                        itemGroup.add(item);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM,
                Identifier.of(ddesamazingmodMod.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
}