package net.kaupenjoe.mccourse.recipe;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<CrystallizerRecipe> CRYSTALLIZER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(MCCourseMod.MOD_ID, "crystallizing"), new CrystallizerRecipe.Serializer());
    public static final RecipeType<CrystallizerRecipe> CRYSTALLIZER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(MCCourseMod.MOD_ID, "crystallizing"), new RecipeType<>() {
                @Override
                public String toString() {
                    return "crystallizing";
                }
            });

    public static void registerRecipes() {
        MCCourseMod.LOGGER.info("Registering Custom Recipes for " + MCCourseMod.MOD_ID);
    }
}
