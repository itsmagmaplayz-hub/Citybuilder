package net.imp.ctb.itemgroup;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.imp.ctb.Citybuilder;
import net.imp.ctb.block.ModBlocks;
import net.imp.ctb.item.ModItems;

public class ModItemGroups {
    public static final ItemGroup CTB_BLOCKS = FabricItemGroup.builder()
            .displayName(Text.literal("CTB Blocks"))
            .icon(() -> new ItemStack(ModBlocks.ASPHALT_ROAD))
            .entries((displayContext, entries) -> {
                // Road blocks
                entries.add(ModItems.ASPHALT_ROAD_ITEM);
                entries.add(ModItems.ASPHALT_ROAD_LINE_ITEM);
                entries.add(ModItems.ASPHALT_CURVE_ITEM);
                entries.add(ModItems.ASPHALT_CORNER_ITEM);
                entries.add(ModItems.YELLOW_PARKING_STRIPE_ITEM);
                
                // Path blocks
                entries.add(ModItems.COBBLE_PATH_ITEM);
                entries.add(ModItems.BRICK_PATH_ITEM);
                entries.add(ModItems.GRAVEL_PATH_ITEM);
                entries.add(ModItems.DIRT_PATH_ITEM);
                
                // Concrete blocks
                entries.add(ModItems.GRAY_CONCRETE_ITEM);
                entries.add(ModItems.WHITE_CONCRETE_ITEM);
                entries.add(ModItems.RED_CONCRETE_ITEM);
                entries.add(ModItems.BLACK_CONCRETE_ITEM);
                entries.add(ModItems.YELLOW_CONCRETE_ITEM);
                entries.add(ModItems.BLUE_CONCRETE_ITEM);
                
                // Parking lot blocks
                entries.add(ModItems.PARKING_SPOT_ITEM);
                entries.add(ModItems.PARKING_LINE_ITEM);
                entries.add(ModItems.PARKING_DIAGONAL_ITEM);
                
                // Sidewalk blocks
                entries.add(ModItems.STONE_SIDEWALK_ITEM);
                entries.add(ModItems.TILED_SIDEWALK_ITEM);
                entries.add(ModItems.BRICK_SIDEWALK_ITEM);
                entries.add(ModItems.MARBLE_SIDEWALK_ITEM);
            })
            .build();

    public static final ItemGroup CTB_FURNITURE = FabricItemGroup.builder()
            .displayName(Text.literal("CTB Furniture"))
            .icon(() -> new ItemStack(ModBlocks.BENCH))
            .entries((displayContext, entries) -> {
                // Street furniture
                entries.add(ModItems.STREET_LAMP_ITEM);
                entries.add(ModItems.STREET_SIGN_ITEM);
                entries.add(ModItems.BENCH_ITEM);
                entries.add(ModItems.TRASH_BIN_ITEM);
                entries.add(ModItems.WOODEN_BENCH_ITEM);
                entries.add(ModItems.METAL_FENCE_ITEM);
                entries.add(ModItems.BOLLARD_ITEM);
                entries.add(ModItems.FIRE_HYDRANT_ITEM);
                entries.add(ModItems.BUS_STOP_ITEM);
                entries.add(ModItems.PLANTER_ITEM);
                entries.add(ModItems.STREET_CLOCK_ITEM);
                entries.add(ModItems.INFORMATIONAL_SIGN_ITEM);
                entries.add(ModItems.WOODEN_TABLE_ITEM);
                entries.add(ModItems.METAL_CHAIR_ITEM);
                entries.add(ModItems.PHONE_BOOTH_ITEM);
            })
            .build();

    public static final ItemGroup CTB_ITEMS = FabricItemGroup.builder()
            .displayName(Text.literal("CTB Items"))
            .icon(() -> new ItemStack(ModItems.CONSTRUCTION_TAPE))
            .entries((displayContext, entries) -> {
                entries.add(ModItems.CONSTRUCTION_TAPE);
                entries.add(ModItems.STREET_DUST);
                entries.add(ModItems.TRAFFIC_CONE);
                entries.add(ModItems.MANHOLE_COVER);
                entries.add(ModItems.CONSTRUCTION_SIGN);
                entries.add(ModItems.BARRIER_TAPE);
                entries.add(ModItems.STREET_PAINT);
            })
            .build();

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(Citybuilder.MOD_ID, "ctb_blocks"), CTB_BLOCKS);
        Registry.register(Registries.ITEM_GROUP, new Identifier(Citybuilder.MOD_ID, "ctb_furniture"), CTB_FURNITURE);
        Registry.register(Registries.ITEM_GROUP, new Identifier(Citybuilder.MOD_ID, "ctb_items"), CTB_ITEMS);
    }
}
