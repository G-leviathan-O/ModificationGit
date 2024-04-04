package ru.andrey.modification.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import ru.andrey.modification.item.ModItems;
import ru.andrey.modification.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider
{
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) { super(output, completableFuture); }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg)
    {
        //Стрела
        getOrCreateTagBuilder(ItemTags.ARROWS).add(ModItems.URANIUM_ARROW);

        //Мясо
        getOrCreateTagBuilder(ModTags.Items.MEATS)
                .add(Items.BEEF)
                .add(Items.PORKCHOP)
                .add(Items.CHICKEN);
    }
}