package ru.andrey.modification.item;

import ru.andrey.modification.Modification;
import ru.andrey.modification.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups
{
    public static final ItemGroup MODIFICATION_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Modification.MOD_ID, "modification_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.modification.modification_group")).icon(() -> new ItemStack(ModItems.TIN_INGOT)).entries((displayContext, entries) ->
            {
                entries.add(ModBlocks.TIN_ORE);
                entries.add(ModBlocks.URANIUM_ORE);
                entries.add(ModBlocks.SULFUR_ORE);
                entries.add(ModBlocks.TIN_DEEPSLATE_ORE);
                entries.add(ModBlocks.URANIUM_DEEPSLATE_ORE);
                entries.add(ModBlocks.TIN_RAW_BLOCK);
                entries.add(ModBlocks.URANIUM_RAW_BLOCK);
                entries.add(ModBlocks.TIN_BLOCK);
                entries.add(ModBlocks.URANIUM_BLOCK);
                entries.add(ModBlocks.SALT_BLOCK);

                entries.add(ModItems.TIN_INGOT);
                entries.add(ModItems.URANIUM_INGOT);
                entries.add(ModItems.TIN_RAW);
                entries.add(ModItems.URANIUM_RAW);
                entries.add(ModItems.TIN_NUGGET);
                entries.add(ModItems.URANIUM_NUGGET);
                entries.add(ModItems.SULFUR);
                entries.add(ModItems.COAL_BRIQUETTE);
                entries.add(ModItems.SALT);
                entries.add(ModItems.TIN);
                entries.add(ModItems.STEW);

                entries.add(ModItems.METAL_DETECTOR);
                entries.add(ModItems.METAL_DETECTOR_V2);
                entries.add(ModItems.URANIUM_ARROW);

            }).build());


    public static void registerItemGroups()
    { Modification.LOGGER.info("Registering item groups for: " + Modification.MOD_ID);}
}