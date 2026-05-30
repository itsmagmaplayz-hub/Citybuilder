package net.imp.ctb.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class StandableSignBlock extends Block {
    // Define the shape of the sign (standing sign post)
    private static final VoxelShape SHAPE = Block.createCuboidShape(6, 0, 6, 10, 14, 10);

    public StandableSignBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            // In a full implementation, this could open a GUI for editing sign text
            player.sendMessage(net.minecraft.text.Text.literal("§6Street Sign - Right-click with a sign to edit"), false);
        }
        return ActionResult.SUCCESS;
    }
}
