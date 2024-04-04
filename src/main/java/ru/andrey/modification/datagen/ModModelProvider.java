package ru.andrey.modification.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import ru.andrey.modification.block.ModBlocks;
import ru.andrey.modification.item.ModItems;

public class ModModelProvider extends FabricModelProvider
{
    public ModModelProvider(FabricDataOutput output) { super(output); }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_RAW_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_RAW_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SULFUR_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SALT_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        itemModelGenerator.register(ModItems.TIN_RAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_RAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.SULFUR, Models.GENERATED);
        itemModelGenerator.register(ModItems.COAL_BRIQUETTE, Models.GENERATED);

        itemModelGenerator.register(ModItems.SALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_ARROW, Models.GENERATED);

        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR_V2, Models.GENERATED);
    }
}