package net.crossover661.endercompass.datagen;

import java.util.function.Consumer;

import net.crossover661.endercompass.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

public class ModRecipeGenerator extends FabricRecipeProvider {
    
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ENDER_COMPASS)
            .pattern(" x ")
            .pattern("xyx")
            .pattern(" x ")
            .input('x', Items.ENDER_EYE)
            .input('y', Items.COMPASS)
            .criterion(FabricRecipeProvider.hasItem(Items.ENDER_EYE), FabricRecipeProvider.conditionsFromItem(Items.ENDER_EYE))
            .criterion(FabricRecipeProvider.hasItem(Items.COMPASS), FabricRecipeProvider.conditionsFromItem(Items.COMPASS))
            .offerTo(exporter);
    }
}