package com.ddededodediamante;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
        public static final SoundEvent SKIBIDI_PENGUINMOD_SONG = registerSoundEvent("skibidi_penguinmod_song");
        public static final RegistryKey<JukeboxSong> SKIBIDI_PENGUINMOD_SONG_KEY = RegistryKey.of(
                        RegistryKeys.JUKEBOX_SONG,
                        Identifier.of(ddesamazingmodMod.MOD_ID, "skibidi_penguinmod_song"));

        public static final SoundEvent CRYSTAL_CAVE = registerSoundEvent("crystal_cave");
        public static final RegistryKey<JukeboxSong> CRYSTAL_CAVE_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG,
                        Identifier.of(ddesamazingmodMod.MOD_ID, "crystal_cave"));

        public static final SoundEvent CAKETOWN = registerSoundEvent("caketown");
        public static final RegistryKey<JukeboxSong> CAKETOWN_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG,
                        Identifier.of(ddesamazingmodMod.MOD_ID, "caketown"));

        public static final SoundEvent DIE_ROLLING = registerSoundEvent("die_rolling");
        public static final RegistryKey<SoundEvent> DIE_ROLLING_KEY = RegistryKey.of(RegistryKeys.SOUND_EVENT,
                        Identifier.of(ddesamazingmodMod.MOD_ID, "die_rolling"));

        public static final SoundEvent SCREAM = registerSoundEvent("scream");
        public static final RegistryKey<SoundEvent> SCREAM_KEY = RegistryKey.of(RegistryKeys.SOUND_EVENT,
                        Identifier.of(ddesamazingmodMod.MOD_ID, "scream"));

        private static SoundEvent registerSoundEvent(String name) {
                Identifier id = Identifier.of(ddesamazingmodMod.MOD_ID, name);
                return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
        }

        public static void initialize() {
        }
}
