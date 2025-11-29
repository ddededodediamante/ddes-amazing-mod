package com.ddededodediamante.screen;

import com.ddededodediamante.ddesamazingmodMod;
import com.ddededodediamante.screen.custom.DieBlockScreenHandler;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<DieBlockScreenHandler> DIE_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER, Identifier.of(ddesamazingmodMod.MOD_ID, "die_screen_handler"),
            new ExtendedScreenHandlerType<>(DieBlockScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void initialize() {
    }
}
