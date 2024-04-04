package ru.andrey.modification.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import ru.andrey.modification.block.ModBlocks;
import ru.andrey.modification.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider
{
    public ModLootTableProvider(FabricDataOutput dataOutput)
    {
        super(dataOutput);
    }

    @Override
    public void generate()
    {
        //Выпадение блока, соответствующего сломаному
        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.TIN_RAW_BLOCK);
        addDrop(ModBlocks.URANIUM_BLOCK);
        addDrop(ModBlocks.URANIUM_RAW_BLOCK);

        //Выпадение руды
        addDrop(ModBlocks.TIN_ORE, oreDrops(ModBlocks.TIN_ORE, ModItems.TIN_RAW));
        addDrop(ModBlocks.TIN_DEEPSLATE_ORE, oreDrops(ModBlocks.TIN_DEEPSLATE_ORE, ModItems.TIN_RAW));
        addDrop(ModBlocks.URANIUM_ORE, oreDrops(ModBlocks.URANIUM_ORE, ModItems.TIN_RAW));
        addDrop(ModBlocks.URANIUM_DEEPSLATE_ORE, oreDrops(ModBlocks.URANIUM_DEEPSLATE_ORE, ModItems.TIN_RAW));

        addDrop(ModBlocks.SULFUR_ORE, lossOfSeveralWithoutFortune(ModBlocks.SULFUR_ORE, ModItems.SULFUR, 2.0f, 4.0f));
        addDrop(ModBlocks.SALT_BLOCK, lossOfSeveralWithoutFortune(ModBlocks.SALT_BLOCK, ModItems.SALT, 3.0f, 5.0f));
    }

    public LootTable.Builder lossOfSeveralWithoutFortune(Block drop, Item item, float min, float max)
    {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop, ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(min, max))))
                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}