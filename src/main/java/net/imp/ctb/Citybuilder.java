package net.imp.ctb;

import net.fabricmc.api.ModInitializer;
import net.imp.ctb.block.ModBlocks;
import net.imp.ctb.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Citybuilder implements ModInitializer {
	public static final String MOD_ID = "citybuilder";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
        LOGGER.info("Initializing Citybuilder 1.20.4");
        LOGGER.info("Loading mod Citybuilder 1.20.4");
		ModBlocks.registerModBlocks();
		LOGGER.info("Loading all modded blocks from Citybuilder 1.20.4");
		ModItems.registerModItems();
        LOGGER.info("Loading all modded items from Citybuilder 1.20.4");
        LOGGER.info("Citybuilder 1.20.4 Initialized");
        LOGGER.info("___ ___ __ ");
        LOGGER.info("|    |  || ");
        LOGGER.info("|    |  |--");
        LOGGER.info("|    |  | |");
        LOGGER.info("---  |  ---");
        LOGGER.info("Mod loaded successfully: Citybuilder 1.20.4");
	}
}