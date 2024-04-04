package ru.andrey.modification.item;

import ru.andrey.modification.Modification;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import ru.andrey.modification.item.custom.MetalDetectorV1Item;
import ru.andrey.modification.item.custom.MetalDetectorV2Item;
import ru.andrey.modification.item.custom.UraniumArrowItem;

public class ModItems
{
    public static final Item TIN_RAW = registerItem("tin_raw", new Item(new FabricItemSettings()));
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings()));
    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item(new FabricItemSettings()));
    public static final Item URANIUM_RAW = registerItem("uranium_raw", new Item(new FabricItemSettings()));
    public static final Item URANIUM_INGOT = registerItem("uranium_ingot", new Item(new FabricItemSettings()));
    public static final Item URANIUM_NUGGET = registerItem("uranium_nugget", new Item(new FabricItemSettings()));
    public static final Item SULFUR = registerItem("sulfur", new Item(new FabricItemSettings()));
    public static final Item SALT = registerItem("salt", new Item(new FabricItemSettings()));

    public static final Item COAL_BRIQUETTE = registerItem("coal_briquette", new Item(new FabricItemSettings()));
    public static final Item URANIUM_ARROW = registerItem("uranium_arrow", new UraniumArrowItem(new FabricItemSettings()));

    public static final Item TIN = registerItem("tin", new Item(new FabricItemSettings().maxCount(16)));
    public static final Item STEW = registerItem("stew", new Item(new FabricItemSettings().food(ModFoodComponents.STEW).maxCount(16)));

    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorV1Item(new FabricItemSettings().maxDamage(128)));
    public static final Item METAL_DETECTOR_V2 = registerItem("metal_detector_v2", new MetalDetectorV2Item(new FabricItemSettings().maxDamage(256)));


    private static Item registerItem(String id, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(Modification.MOD_ID, id), item);
    }
    public static void registerModItem() { Modification.LOGGER.info("Registering item for: " + Modification.MOD_ID);}
}