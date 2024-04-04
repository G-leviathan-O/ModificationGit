package ru.andrey.modification.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import ru.andrey.modification.Modification;
import ru.andrey.modification.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures
{
    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> URANIUM_ORE_KEY = registerKey("uranium_ore_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY = registerKey("sulfur_ore_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SALT_BLOCK_KEY = registerKey("salt_block_key");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context)
    {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldTinOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.TIN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.TIN_DEEPSLATE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldUraniumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.URANIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.URANIUM_DEEPSLATE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldSulfurOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.SULFUR_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldSaltBlocks =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.SALT_BLOCK.getDefaultState()));


        register(context, TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTinOres, 8));
        register(context, URANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldUraniumOres, 8));
        register(context, SULFUR_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSulfurOres, 12));
        register(context, SALT_BLOCK_KEY, Feature.ORE, new OreFeatureConfig(overworldSaltBlocks, 6));
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name)
    {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Modification.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}