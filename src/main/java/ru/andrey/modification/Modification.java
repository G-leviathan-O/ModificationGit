package ru.andrey.modification;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import ru.andrey.modification.block.ModBlocks;
import ru.andrey.modification.item.ModItemGroups;
import ru.andrey.modification.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.andrey.modification.world.gen.ModWorldGeneration;

public class Modification implements ModInitializer
{
	public static final String MOD_ID = "modification";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{

		ModItems.registerModItem();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		ModWorldGeneration.generateModWorldGen();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 800);
	}
}