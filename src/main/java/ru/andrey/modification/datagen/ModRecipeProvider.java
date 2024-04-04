package ru.andrey.modification.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import ru.andrey.modification.block.ModBlocks;
import ru.andrey.modification.item.ModItems;
import ru.andrey.modification.util.ModTags;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider
{
    private static final List<ItemConvertible> TIN_SMELTING = List.of(ModBlocks.TIN_ORE, ModBlocks.TIN_DEEPSLATE_ORE, ModItems.TIN_RAW);
    private static final List<ItemConvertible> URANIUM_SMELTING = List.of(ModBlocks.URANIUM_ORE, ModBlocks.URANIUM_DEEPSLATE_ORE, ModItems.URANIUM_RAW);

    public ModRecipeProvider(FabricDataOutput output) { super(output); }

    @Override
    public void generate(RecipeExporter exporter)
    {
        offerSmelting(exporter, TIN_SMELTING, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.6f, 200, "tin_ingot");
        offerBlasting(exporter, TIN_SMELTING, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.6f, 100, "tin_ingot");
        offerSmelting(exporter, URANIUM_SMELTING, RecipeCategory.MISC, ModItems.URANIUM_INGOT, 0.6f, 200, "tin_ingot");
        offerBlasting(exporter, URANIUM_SMELTING, RecipeCategory.MISC, ModItems.URANIUM_INGOT, 0.6f, 100, "tin_ingot");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TIN_RAW, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_RAW_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TIN_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_BLOCK, getRecipeName(ModBlocks.TIN_BLOCK), null, "tin_ingot_from_block", null);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TIN_NUGGET, RecipeCategory.MISC, ModItems.TIN_INGOT, "tin_ingot_from_nuggets", null, getRecipeName(ModItems.TIN_NUGGET), null);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.URANIUM_RAW, RecipeCategory.BUILDING_BLOCKS, ModBlocks.URANIUM_RAW_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.URANIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.URANIUM_BLOCK, getRecipeName(ModBlocks.URANIUM_BLOCK), null, "uranium_ingot_from_block", null);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.URANIUM_NUGGET, RecipeCategory.MISC, ModItems.URANIUM_INGOT, "uranium_ingot_from_nuggets", null, getRecipeName(ModItems.URANIUM_NUGGET), null);
        offerReversibleCompacting2x2Recipes(exporter, RecipeCategory.MISC, ModItems.SALT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SALT_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COAL_BRIQUETTE, 1)
                .pattern(" S ")
                .pattern("SCS")
                .pattern(" S ")
                .input('S', ModItems.SULFUR)
                .input('C', ItemTags.COALS)
                .criterion(hasItem(ModItems.SULFUR), conditionsFromItem(ModItems.SULFUR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COAL_BRIQUETTE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.URANIUM_ARROW, 4)
                .pattern(" U ")
                .pattern(" S ")
                .pattern(" F ")
                .input('U', ModItems.URANIUM_INGOT)
                .input('S', Items.STICK)
                .input('F', Items.FEATHER)
                .criterion(hasItem(ModItems.URANIUM_INGOT), conditionsFromItem(ModItems.URANIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.URANIUM_ARROW)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN, 1)
                .pattern("TTT")
                .pattern("T T")
                .pattern("TTT")
                .input('T', ModItems.TIN_NUGGET)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TIN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEW, 1)
                .pattern("SMS")
                .pattern("MTM")
                .pattern("SMS")
                .input('T', ModItems.TIN)
                .input('M', ModTags.Items.MEATS)
                .input('S', ModItems.SALT)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEW)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.METAL_DETECTOR, 1)
                .pattern(" IR")
                .pattern("RGI")
                .pattern("S  ")
                .input('R', Items.REDSTONE)
                .input('I', Items.IRON_INGOT)
                .input('G', Items.GOLD_INGOT)
                .input('S',Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.METAL_DETECTOR)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.METAL_DETECTOR_V2, 1)
                .pattern(" NS")
                .pattern("CMN")
                .pattern("B  ")
                .input('S', Items.SCULK_SENSOR)
                .input('N', Items.NETHERITE_INGOT)
                .input('C', Items.SCULK)
                .input('B',Items.BLAZE_ROD)
                .input('M', ModItems.METAL_DETECTOR)
                .criterion(hasItem(Items.SCULK), conditionsFromItem(Items.SCULK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.METAL_DETECTOR_V2)));
    }


    public static void offerReversibleCompacting2x2Recipes(RecipeExporter exporter, RecipeCategory reverseCategory, ItemConvertible baseItem, RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingId, @Nullable String compactingGroup, String reverseId, @Nullable String reverseGroup)
    {
        ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 4).input(compactItem).group(reverseGroup).criterion(hasItem(compactItem), conditionsFromItem(compactItem)).offerTo(exporter, new Identifier(reverseId));
        ShapedRecipeJsonBuilder.create(compactingCategory, compactItem).input('#', baseItem).pattern("##").pattern("##").group(compactingGroup).criterion(hasItem(baseItem), conditionsFromItem(baseItem)).offerTo(exporter, new Identifier(compactingId));
    }
    public static void offerReversibleCompacting2x2Recipes(RecipeExporter exporter, RecipeCategory reverseCategory, ItemConvertible baseItem, RecipeCategory compactingCategory, ItemConvertible compactItem) {
        offerReversibleCompacting2x2Recipes(exporter, reverseCategory, baseItem, compactingCategory, compactItem, getRecipeName(compactItem), (String)null, getRecipeName(baseItem), (String)null);
    }
}