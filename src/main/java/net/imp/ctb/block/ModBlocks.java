package net.imp.ctb.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.imp.ctb.Citybuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    // ===== ROAD BLOCKS =====
    public static final Block ASPHALT_ROAD = registerBlock("asphalt_road",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(2.0f, 6.0f)));

    public static final Block ASPHALT_ROAD_LINE = registerBlock("asphalt_road_line",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(2.0f, 6.0f)));

    public static final Block ASPHALT_CURVE = registerBlock("asphalt_curve",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(2.0f, 6.0f)));

    public static final Block ASPHALT_CORNER = registerBlock("asphalt_corner",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(2.0f, 6.0f)));

    public static final Block YELLOW_PARKING_STRIPE = registerBlock("yellow_parking_stripe",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(2.0f, 6.0f)));

    // ===== PATH BLOCKS =====
    public static final Block COBBLE_PATH = registerBlock("cobble_path",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).strength(1.5f, 6.0f)));

    public static final Block BRICK_PATH = registerBlock("brick_path",
            new Block(FabricBlockSettings.copyOf(Blocks.BRICKS).strength(1.5f, 6.0f)));

    public static final Block GRAVEL_PATH = registerBlock("gravel_path",
            new Block(FabricBlockSettings.copyOf(Blocks.GRAVEL).strength(0.6f, 1.0f)));

    public static final Block DIRT_PATH = registerBlock("dirt_path",
            new Block(FabricBlockSettings.copyOf(Blocks.DIRT).strength(0.5f, 0.5f)));

    // ===== CONCRETE BLOCKS =====
    public static final Block GRAY_CONCRETE = registerBlock("gray_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.GRAY_CONCRETE).strength(1.8f, 9.0f)));

    public static final Block WHITE_CONCRETE = registerBlock("white_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).strength(1.8f, 9.0f)));

    public static final Block RED_CONCRETE = registerBlock("red_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.RED_CONCRETE).strength(1.8f, 9.0f)));

    public static final Block BLACK_CONCRETE = registerBlock("black_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE).strength(1.8f, 9.0f)));

    public static final Block YELLOW_CONCRETE = registerBlock("yellow_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.YELLOW_CONCRETE).strength(1.8f, 9.0f)));

    public static final Block BLUE_CONCRETE = registerBlock("blue_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.BLUE_CONCRETE).strength(1.8f, 9.0f)));

    // ===== PARKING LOT BLOCKS =====
    public static final Block PARKING_SPOT = registerBlock("parking_spot",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(2.0f, 6.0f)));

    public static final Block PARKING_LINE = registerBlock("parking_line",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(2.0f, 6.0f)));

    public static final Block PARKING_DIAGONAL = registerBlock("parking_diagonal",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(2.0f, 6.0f)));

    // ===== SIDEWALK BLOCKS =====
    public static final Block STONE_SIDEWALK = registerBlock("stone_sidewalk",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS).strength(1.5f, 6.0f)));

    public static final Block TILED_SIDEWALK = registerBlock("tiled_sidewalk",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS).strength(1.5f, 6.0f)));

    public static final Block BRICK_SIDEWALK = registerBlock("brick_sidewalk",
            new Block(FabricBlockSettings.copyOf(Blocks.BRICKS).strength(1.5f, 6.0f)));

    public static final Block MARBLE_SIDEWALK = registerBlock("marble_sidewalk",
            new Block(FabricBlockSettings.copyOf(Blocks.CALCITE).strength(2.0f, 6.0f)));

    // ===== STREET FURNITURE - DECORATIVE =====
    public static final Block STREET_LAMP = registerBlock("street_lamp",
            new LightPost(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(2.0f, 6.0f).luminance(state -> 15)));

    public static final Block STREET_SIGN = registerBlock("street_sign",
            new StandableSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(2.0f, 3.0f)));

    public static final Block BENCH = registerBlock("bench",
            new SittableBench(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(2.0f, 3.0f)));

    public static final Block TRASH_BIN = registerBlock("trash_bin",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(1.5f, 3.0f)));

    public static final Block WOODEN_BENCH = registerBlock("wooden_bench",
            new SittableBench(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(2.0f, 3.0f)));

    public static final Block METAL_FENCE = registerBlock("metal_fence",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BARS).strength(2.0f, 6.0f)));

    public static final Block BOLLARD = registerBlock("bollard",
            new LightPost(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(1.5f, 3.0f)));

    public static final Block FIRE_HYDRANT = registerBlock("fire_hydrant",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(2.0f, 3.0f)));

    public static final Block BUS_STOP = registerBlock("bus_stop",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(3.0f, 6.0f)));

    public static final Block PLANTER = registerBlock("planter",
            new Block(FabricBlockSettings.copyOf(Blocks.TERRACOTTA).strength(1.25f, 4.2f)));

    public static final Block STREET_CLOCK = registerBlock("street_clock",
            new LightPost(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(2.0f, 6.0f).luminance(state -> 10)));

    public static final Block INFORMATIONAL_SIGN = registerBlock("informational_sign",
            new StandableSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(2.0f, 3.0f)));

    public static final Block WOODEN_TABLE = registerBlock("wooden_table",
            new TableBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(2.0f, 3.0f)));

    public static final Block METAL_CHAIR = registerBlock("metal_chair",
            new ChairBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(1.5f, 3.0f)));

    public static final Block PHONE_BOOTH = registerBlock("phone_booth",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(2.0f, 6.0f).luminance(state -> 8)));

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Citybuilder.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        Citybuilder.LOGGER.info("Registering Mod Blocks for " + Citybuilder.MOD_ID);
    }
}
