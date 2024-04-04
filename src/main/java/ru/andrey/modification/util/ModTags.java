package ru.andrey.modification.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import ru.andrey.modification.Modification;

public class ModTags
{
    public static class Blocks
    {
        public static TagKey<Block> TIN_ORES = createTag("tin_ores");
        public static TagKey<Block> URANIUM_ORES = createTag("uranium_ores");

        public static TagKey<Block> METAL_DETECTOR_V1_DETECTABLE_BLOCKS = createTag("metal_detector_v1_detectable_blocks");
        public static TagKey<Block> METAL_DETECTOR_V2_DETECTABLE_BLOCKS = createTag("metal_detector_v2_detectable_blocks");

        private static TagKey<Block> createTag(String id)
        {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Modification.MOD_ID, id));
        }
    }

    public static class Items
    {
        public static TagKey<Item> MEATS = createTag("meats");

        private static TagKey<Item> createTag(String id)
        {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Modification.MOD_ID, id));
        }
    }
}