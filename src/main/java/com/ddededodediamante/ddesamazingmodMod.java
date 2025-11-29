package com.ddededodediamante;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ddededodediamante.block.entity.ModBlockEntities;
import com.ddededodediamante.screen.ModScreenHandlers;

public class ddesamazingmodMod implements ModInitializer {
	public static final String MOD_ID = "ddesamazingmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello dde's Amazing world!");
		
        ModItemGroups.register();
		ModItems.initialize();
		ModBlocks.initialize();
		ModBlockEntities.initialize();
		ModSounds.initialize();
		ModEffects.initialize();
		ModPotions.initialize();
		ModScreenHandlers.initialize();
	}
}