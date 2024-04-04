package ru.andrey.modification.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.andrey.modification.entity.UraniumArrowEntity;

public class UraniumArrowItem extends ArrowItem
{
    public UraniumArrowItem(Item.Settings settings) { super(settings); }

    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter)
    {
        return new UraniumArrowEntity(world, shooter);
    }
}