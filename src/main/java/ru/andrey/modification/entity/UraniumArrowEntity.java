package ru.andrey.modification.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import ru.andrey.modification.item.ModItems;

public class UraniumArrowEntity extends PersistentProjectileEntity
{
    private int duration = 200;

    public UraniumArrowEntity(EntityType<? extends SpectralArrowEntity> entityType, World world)
    {
        super(entityType, world);
    }
    public UraniumArrowEntity(World world, LivingEntity owner)
    {
        super(EntityType.ARROW, owner, world);
    }
    public UraniumArrowEntity(World world, double x, double y, double z) {
        super(EntityType.ARROW, x, y, z, world);
    }

    public void tick()
    {
        super.tick();
        if (this.getWorld().isClient && !this.inGround)
        {
            this.getWorld().addParticle(ParticleTypes.INSTANT_EFFECT, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }

    }
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.URANIUM_ARROW);
    }

    protected void onHit(LivingEntity target)
    {
        super.onHit(target);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, this.duration - 100, 5), this.getEffectCause());
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, this.duration - 60, 4), this.getEffectCause());
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, this.duration - 60, 4), this.getEffectCause());
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, this.duration, 4), this.getEffectCause());
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, this.duration, 4), this.getEffectCause());
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1), this.getEffectCause());
    }

    public void readCustomDataFromNbt(NbtCompound nbt)
    {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("Duration"))
        {
            this.duration = nbt.getInt("Duration");
        }

    }
    public void writeCustomDataToNbt(NbtCompound nbt)
    {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Duration", this.duration);
    }
}
