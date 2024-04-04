package ru.andrey.modification.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents
{
    public static final FoodComponent STEW = new FoodComponent.Builder().meat().hunger(15).saturationModifier(1)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 0), 0.25f).build();
}