package ru.andrey.modification.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.andrey.modification.util.ModTags;

import java.util.List;

public class MetalDetectorV2Item extends Item
{
    public MetalDetectorV2Item(Settings settings) { super(settings); }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        if (!context.getWorld().isClient())
        {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            int count = 1;
            player.sendMessage(Text.literal("-----------------------------------------------------"), false);

            for (int i = 0; i <= positionClicked.getY() + 64 && count <=9; i++)
            {
                for (int j = -1; j <= 1 && count <=9; j++)
                {
                    for (int k = -1; k <= 1 && count <=9; k++)
                    {
                        BlockState state = context.getWorld().getBlockState(positionClicked.down(i).north(j).east(k));

                        if (isValuableBlock(state))
                        {
                            outputValuableCoordinates(positionClicked.down(i).north(j).east(k), player, state.getBlock());
                            count++;
                        }
                    }
                }
            }
            if (count == 0)
                player.sendMessage(Text.literal("Ценных залежей не найдено"));
        }
        context.getStack().damage(1, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }
    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block)
    {
        player.sendMessage(Text.literal("Найден " + block.asItem().getName().getString() + " (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
    }
    private boolean isValuableBlock(BlockState state)
    {
        return state.isIn(ModTags.Blocks.METAL_DETECTOR_V2_DETECTABLE_BLOCKS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(Text.translatable("tooltip.modification.metal_detector_v2.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}