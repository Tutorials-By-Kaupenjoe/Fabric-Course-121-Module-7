package net.kaupenjoe.mccourse.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.kaupenjoe.mccourse.recipe.CrystallizerRecipe;
import net.minecraft.recipe.RecipeEntry;

import java.util.List;

public class CrystallizerDisplay extends BasicDisplay {
    public CrystallizerDisplay(RecipeEntry<CrystallizerRecipe> recipe) {
        super(List.of(EntryIngredients.ofIngredient(recipe.value().getIngredients().get(0))),
                List.of(EntryIngredient.of(EntryStacks.of(recipe.value().getResult(null)))));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CrystallizerCategory.CRYSTALLIZER;
    }
}
