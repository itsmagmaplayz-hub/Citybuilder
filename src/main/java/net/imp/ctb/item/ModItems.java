package net.imp.ctb.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.imp.ctb.Citybuilder;
import net.imp.ctb.block.ModBlocks;
import net.imp.ctb.itemgroup.ModItemGroups;

public class ModItems {
    // ===== ROAD ITEMS =====
    public static final Item ASPHALT_ROAD_ITEM = registerBlockItem("asphalt_road", ModBlocks.ASPHALT_ROAD);
    public static final Item ASPHALT_ROAD_LINE_ITEM = registerBlockItem("asphalt_road_line", ModBlocks.ASPHALT_ROAD_LINE);
    public static final Item ASPHALT_CURVE_ITEM = registerBlockItem("asphalt_curve", ModBlocks.ASPHALT_CURVE);
    public static final Item ASPHALT_CORNER_ITEM = registerBlockItem("asphalt_corner", ModBlocks.ASPHALT_CORNER);
    public static final Item YELLOW_PARKING_STRIPE_ITEM = registerBlockItem("yellow_parking_stripe", ModBlocks.YELLOW_PARKING_STRIPE);

    // ===== PATH ITEMS =====
    public static final Item COBBLE_PATH_ITEM = registerBlockItem("cobble_path", ModBlocks.COBBLE_PATH);
    public static final Item BRICK_PATH_ITEM = registerBlockItem("brick_path", ModBlocks.BRICK_PATH);
    public static final Item GRAVEL_PATH_ITEM = registerBlockItem("gravel_path", ModBlocks.GRAVEL_PATH);
    public static final Item DIRT_PATH_ITEM = registerBlockItem("dirt_path", ModBlocks.DIRT_PATH);

    // ===== CONCRETE ITEMS =====
    public static final Item GRAY_CONCRETE_ITEM = registerBlockItem("gray_concrete", ModBlocks.GRAY_CONCRETE);
    public static final Item WHITE_CONCRETE_ITEM = registerBlockItem("white_concrete", ModBlocks.WHITE_CONCRETE);
    public static final Item RED_CONCRETE_ITEM = registerBlockItem("red_concrete", ModBlocks.RED_CONCRETE);
    public static final Item BLACK_CONCRETE_ITEM = registerBlockItem("black_concrete", ModBlocks.BLACK_CONCRETE);
    public static final Item YELLOW_CONCRETE_ITEM = registerBlockItem("yellow_concrete", ModBlocks.YELLOW_CONCRETE);
    public static final Item BLUE_CONCRETE_ITEM = registerBlockItem("blue_concrete", ModBlocks.BLUE_CONCRETE);

    // ===== PARKING LOT ITEMS =====
    public static final Item PARKING_SPOT_ITEM = registerBlockItem("parking_spot", ModBlocks.PARKING_SPOT);
    public static final Item PARKING_LINE_ITEM = registerBlockItem("parking_line", ModBlocks.PARKING_LINE);
    public static final Item PARKING_DIAGONAL_ITEM = registerBlockItem("parking_diagonal", ModBlocks.PARKING_DIAGONAL);

    // ===== SIDEWALK ITEMS =====
    public static final Item STONE_SIDEWALK_ITEM = registerBlockItem("stone_sidewalk", ModBlocks.STONE_SIDEWALK);
    public static final Item TILED_SIDEWALK_ITEM = registerBlockItem("tiled_sidewalk", ModBlocks.TILED_SIDEWALK);
    public static final Item BRICK_SIDEWALK_ITEM = registerBlockItem("brick_sidewalk", ModBlocks.BRICK_SIDEWALK);
    public static final Item MARBLE_SIDEWALK_ITEM = registerBlockItem("marble_sidewalk", ModBlocks.MARBLE_SIDEWALK);

    // ===== STREET FURNITURE ITEMS =====
    public static final Item STREET_LAMP_ITEM = registerBlockItem("street_lamp", ModBlocks.STREET_LAMP);
    public static final Item STREET_SIGN_ITEM = registerBlockItem("street_sign", ModBlocks.STREET_SIGN);
    public static final Item BENCH_ITEM = registerBlockItem("bench", ModBlocks.BENCH);
    public static final Item TRASH_BIN_ITEM = registerBlockItem("trash_bin", ModBlocks.TRASH_BIN);
    public static final Item WOODEN_BENCH_ITEM = registerBlockItem("wooden_bench", ModBlocks.WOODEN_BENCH);
    public static final Item METAL_FENCE_ITEM = registerBlockItem("metal_fence", ModBlocks.METAL_FENCE);
    public static final Item BOLLARD_ITEM = registerBlockItem("bollard", ModBlocks.BOLLARD);
    public static final Item FIRE_HYDRANT_ITEM = registerBlockItem("fire_hydrant", ModBlocks.FIRE_HYDRANT);
    public static final Item BUS_STOP_ITEM = registerBlockItem("bus_stop", ModBlocks.BUS_STOP);
    public static final Item PLANTER_ITEM = registerBlockItem("planter", ModBlocks.PLANTER);
    public static final Item STREET_CLOCK_ITEM = registerBlockItem("street_clock", ModBlocks.STREET_CLOCK);
    public static final Item INFORMATIONAL_SIGN_ITEM = registerBlockItem("informational_sign", ModBlocks.INFORMATIONAL_SIGN);
    public static final Item WOODEN_TABLE_ITEM = registerBlockItem("wooden_table", ModBlocks.WOODEN_TABLE);
    public static final Item METAL_CHAIR_ITEM = registerBlockItem("metal_chair", ModBlocks.METAL_CHAIR);
    public static final Item PHONE_BOOTH_ITEM = registerBlockItem("phone_booth", ModBlocks.PHONE_BOOTH);

    // ===== STANDALONE ITEMS =====
    public static final Item CONSTRUCTION_TAPE = registerItem("construction_tape", new Item(new Item.Settings()));
    public static final Item STREET_DUST = registerItem("street_dust", new Item(new Item.Settings()));
    public static final Item TRAFFIC_CONE = registerItem("traffic_cone", new Item(new Item.Settings()));
    public static final Item MANHOLE_COVER = registerItem("manhole_cover", new Item(new Item.Settings()));
    public static final Item CONSTRUCTION_SIGN = registerItem("construction_sign", new Item(new Item.Settings()));
    public static final Item BARRIER_TAPE = registerItem("barrier_tape", new Item(new Item.Settings()));
    public static final Item STREET_PAINT = registerItem("street_paint", new Item(new Item.Settings()));

    private static Item registerBlockItem(String name, net.minecraft.block.Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Citybuilder.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Citybuilder.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Citybuilder.LOGGER.info("Registering Mod Items for " + Citybuilder.MOD_ID);
        
        // Register custom item groups
        ModItemGroups.registerItemGroups();
    }
}
