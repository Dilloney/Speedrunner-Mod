package com.dilloney.speedrunnermod.blocks;

import com.dilloney.speedrunnermod.registry.ModItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public final class ModBlocks {

    public static final Block SPEEDRUNNER_BLOCK = new Block(FabricBlockSettings.of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 1)
            .requiresTool()
            .strength(5.0F, 6.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block SPEEDRUNNER_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 1)
            .requiresTool()
            .strength(3.0F, 3.0F)
            .sounds(BlockSoundGroup.STONE), UniformIntProvider.create(64, 128));

    public static final Block DEEPSLATE_SPEEDRUNNER_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 1)
            .requiresTool()
            .strength(4.5F, 4.5F)
            .sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(72, 128));

    public static final Block NETHER_SPEEDRUNNER_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 3.0F)
            .sounds(BlockSoundGroup.NETHER_GOLD_ORE), UniformIntProvider.create(32, 64));

    public static final Block IGNEOUS_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 3.0F)
            .sounds(BlockSoundGroup.STONE), UniformIntProvider.create(2, 6));

    public static final Block DEEPSLATE_IGNEOUS_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(4.5F, 4.5F)
            .sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(2, 6));

    public static final Block NETHER_IGNEOUS_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 3.0F)
            .sounds(BlockSoundGroup.NETHER_ORE), UniformIntProvider.create(2, 6));

    public static final BlockItem SPEEDRUNNER_BLOCK_ITEM = new BlockItem(SPEEDRUNNER_BLOCK,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD_ITEM_GROUP).group(ItemGroup.MATERIALS).rarity(Rarity.COMMON));

    public static final BlockItem SPEEDRUNNER_ORE_BLOCK_ITEM = new BlockItem(SPEEDRUNNER_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD_ITEM_GROUP).group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.COMMON));

    public static final BlockItem DEEPSLATE_SPEEDRUNNER_ORE_BLOCK_ITEM = new BlockItem(DEEPSLATE_SPEEDRUNNER_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD_ITEM_GROUP).group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.COMMON));

    public static final BlockItem NETHER_SPEEDRUNNER_ORE_BLOCK_ITEM = new BlockItem(NETHER_SPEEDRUNNER_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD_ITEM_GROUP).group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.COMMON));

    public static final BlockItem IGNEOUS_ORE_BLOCK_ITEM = new BlockItem(IGNEOUS_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD_ITEM_GROUP).group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.COMMON));

    public static final BlockItem DEEPSLATE_IGNEOUS_ORE_BLOCK_ITEM = new BlockItem(DEEPSLATE_IGNEOUS_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD_ITEM_GROUP).group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.COMMON));

    public static final BlockItem NETHER_IGNEOUS_ORE_BLOCK_ITEM = new BlockItem(NETHER_IGNEOUS_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD_ITEM_GROUP).group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.COMMON));
}
