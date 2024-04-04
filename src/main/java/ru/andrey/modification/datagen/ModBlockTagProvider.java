package ru.andrey.modification.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import ru.andrey.modification.block.ModBlocks;
import ru.andrey.modification.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider
{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) { super(output, registriesFuture); }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg)
    {
        //Руды из мода
        getOrCreateTagBuilder(ModTags.Blocks.TIN_ORES)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.TIN_DEEPSLATE_ORE);
        getOrCreateTagBuilder(ModTags.Blocks.URANIUM_ORES)
                .add(ModBlocks.URANIUM_ORE)
                .add(ModBlocks.URANIUM_DEEPSLATE_ORE);

        //Блоки, детектируемые металлодетектором
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_V1_DETECTABLE_BLOCKS)
                .forceAddTag(ModTags.Blocks.TIN_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.COAL_ORES)
                .add(Blocks.RAW_IRON_BLOCK)
                .add(Blocks.RAW_COPPER_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_V2_DETECTABLE_BLOCKS)
                .forceAddTag(ModTags.Blocks.METAL_DETECTOR_V1_DETECTABLE_BLOCKS)
                .forceAddTag(ModTags.Blocks.URANIUM_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .add(ModBlocks.SULFUR_ORE)
                .add(Blocks.NETHER_QUARTZ_ORE)
                .add(Blocks.ANCIENT_DEBRIS)
                .add(Blocks.BUDDING_AMETHYST);

        //Требование инструментов
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(ModTags.Blocks.TIN_ORES)
                .forceAddTag(ModTags.Blocks.URANIUM_ORES)
                .add(ModBlocks.TIN_RAW_BLOCK)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.URANIUM_RAW_BLOCK)
                .add(ModBlocks.URANIUM_BLOCK)
                .add(ModBlocks.SULFUR_ORE)
                .add(ModBlocks.SALT_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .forceAddTag(ModTags.Blocks.TIN_ORES)
                .add(ModBlocks.TIN_RAW_BLOCK)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.SULFUR_ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .forceAddTag(ModTags.Blocks.URANIUM_ORES)
                .add(ModBlocks.URANIUM_RAW_BLOCK)
                .add(ModBlocks.URANIUM_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")));
    }
}