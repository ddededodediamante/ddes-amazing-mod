package com.ddededodediamante;

import com.ddededodediamante.screen.ModScreenHandlers;
import com.ddededodediamante.screen.custom.DieBlockScreen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;

public class ddesamazingmodModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.POOP_DOOR, BlockRenderLayer.CUTOUT);

        HandledScreens.register(ModScreenHandlers.DIE_SCREEN_HANDLER, DieBlockScreen::new);
    }
}
