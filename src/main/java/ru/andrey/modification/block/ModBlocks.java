package ru.andrey.modification.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import ru.andrey.modification.Modification;
import ru.andrey.modification.block.custom.UraniumBlock;

public class ModBlocks
{
    public static final Block TIN_ORE = registerBlock("tin_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block TIN_DEEPSLATE_ORE = registerBlock("tin_deepslate_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block TIN_RAW_BLOCK = registerBlock("tin_raw_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block TIN_BLOCK = registerBlock("tin_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block URANIUM_ORE = registerBlock("uranium_ore", new UraniumBlock(FabricBlockSettings.copyOf(Blocks.GOLD_ORE)));
    public static final Block URANIUM_DEEPSLATE_ORE = registerBlock("uranium_deepslate_ore", new UraniumBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_GOLD_ORE)));
    public static final Block URANIUM_RAW_BLOCK = registerBlock("uranium_raw_block", new UraniumBlock(FabricBlockSettings.copyOf(Blocks.RAW_GOLD_BLOCK)));
    public static final Block URANIUM_BLOCK = registerBlock("uranium_block", new UraniumBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block SULFUR_ORE = registerBlock("sulfur_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE), UniformIntProvider.create(2, 5)));
    public static final Block SALT_BLOCK = registerBlock("salt_block", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.SAND), UniformIntProvider.create(2, 5)));


    private static Block registerBlock(String id, Block block)
    {
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, new Identifier(Modification.MOD_ID, id), block);
    }
    private static Item registerBlockItem(String id, Block block)
    {
        return Registry.register(Registries.ITEM, new Identifier(Modification.MOD_ID, id), new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() { Modification.LOGGER.info("Registering blocks for: " + Modification.MOD_ID);}
}