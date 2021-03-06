package net.dilloney.speedrunnermod.world.gen.feature;

import net.dilloney.speedrunnermod.block.ModBlocks;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModOreConfiguredFeatures {
    private static final List<OreFeatureConfig.Target> SPEEDRUNNER_ORES;
    private static final List<OreFeatureConfig.Target> IGNEOUS_ORES;
    protected static final ConfiguredFeature<?, ?> ORE_SPEEDRUNNER;
    protected static final ConfiguredFeature<?, ?> ORE_SPEEDRUNNER_SMALL;
    protected static final ConfiguredFeature<?, ?> ORE_NETHER_SPEEDRUNNER;
    protected static final ConfiguredFeature<?, ?> ORE_IGNEOUS;
    protected static final ConfiguredFeature<?, ?> ORE_NETHER_IGNEOUS;

    static {
        SPEEDRUNNER_ORES = List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SPEEDRUNNER_ORE.getDefaultState()), OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SPEEDRUNNER_ORE.getDefaultState()));
        IGNEOUS_ORES = List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.IGNEOUS_ORE.getDefaultState()), OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_IGNEOUS_ORE.getDefaultState()));
        ORE_SPEEDRUNNER = ConfiguredFeatures.register("ore_speedrunner", Feature.ORE.configure(new OreFeatureConfig(SPEEDRUNNER_ORES, 9)));
        ORE_SPEEDRUNNER_SMALL = ConfiguredFeatures.register("ore_speedrunner_small", Feature.ORE.configure(new OreFeatureConfig(SPEEDRUNNER_ORES, 4)));
        ORE_NETHER_SPEEDRUNNER = ConfiguredFeatures.register("ore_nether_speedrunner", Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, ModBlocks.NETHER_SPEEDRUNNER_ORE.getDefaultState(), 10)));
        ORE_IGNEOUS = ConfiguredFeatures.register("ore_igneous", Feature.ORE.configure(new OreFeatureConfig(IGNEOUS_ORES, 4)));
        ORE_NETHER_IGNEOUS = ConfiguredFeatures.register("ore_nether_igneous", Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, ModBlocks.NETHER_IGNEOUS_ORE.getDefaultState(), 4)));
    }
}