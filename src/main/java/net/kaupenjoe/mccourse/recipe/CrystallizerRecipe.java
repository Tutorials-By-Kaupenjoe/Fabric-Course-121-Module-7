package net.kaupenjoe.mccourse.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record CrystallizerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<CrystallizerRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(CrystallizerRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(CrystallizerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CRYSTALLIZER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CRYSTALLIZER_TYPE;
    }

    public static class Serializer implements RecipeSerializer<CrystallizerRecipe> {
        public static final MapCodec<CrystallizerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(CrystallizerRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(CrystallizerRecipe::output)
        ).apply(inst, CrystallizerRecipe::new));
        public static final PacketCodec<RegistryByteBuf, CrystallizerRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, CrystallizerRecipe::inputItem,
                        ItemStack.PACKET_CODEC, CrystallizerRecipe::output,
                        CrystallizerRecipe::new);

        @Override
        public MapCodec<CrystallizerRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, CrystallizerRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
