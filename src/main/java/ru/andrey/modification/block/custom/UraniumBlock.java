package ru.andrey.modification.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import ru.andrey.modification.other.ModParticles;

public class UraniumBlock extends Block
{
    public UraniumBlock(Settings settings) { super(settings); }

    public static final BooleanProperty LIT = Properties.LIT;

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player)
    {
        UraniumBlock.light(state, world, pos);
        super.onBlockBreakStart(state, world, pos, player);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity)
    {
        if (!entity.bypassesSteppingEffects())
            UraniumBlock.light(state, world, pos);
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        light(state, world, pos);
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() instanceof BlockItem && new ItemPlacementContext(player, hand, itemStack, hit).canPlace())
            return ActionResult.PASS;
        return ActionResult.SUCCESS;
    }

    private static void light(BlockState state, World world, BlockPos pos)
    {
        spawnParticles(world, pos);
        if (!state.get(LIT).booleanValue())
            world.setBlockState(pos, state.with(LIT, true), Block.NOTIFY_ALL);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(LIT);
    }

    private static void spawnParticles(World world, BlockPos pos)
    {
        double d = 0.5625;
        Random random = world.random;
        for (Direction direction : Direction.values())
        {
            BlockPos blockPos = pos.offset(direction);
            if (world.getBlockState(blockPos).isOpaqueFullCube(world, blockPos)) continue;
            Direction.Axis axis = direction.getAxis();
            double e = axis == Direction.Axis.X ? 0.5 + d * (double)direction.getOffsetX() : (double)random.nextFloat();
            double f = axis == Direction.Axis.Y ? 0.5 + d * (double)direction.getOffsetY() : (double)random.nextFloat();
            double g = axis == Direction.Axis.Z ? 0.5 + d * (double)direction.getOffsetZ() : (double)random.nextFloat();
            world.addParticle(ModParticles.ModDustParticleEffect.GREEN, (double)pos.getX() + e, (double)pos.getY() + f, (double)pos.getZ() + g, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience)
    {
        super.onStacksDropped(state, world, pos, tool, dropExperience);
        if (dropExperience && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, tool) == 0)
        {
            int i = 1 + world.random.nextInt(5);
            this.dropExperience(world, pos, i);
        }
    }
}