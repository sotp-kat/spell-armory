package net.sotp_kat.spell_armory.registries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class BrewingRegistry {
    public static void register() {
        addRecipe(ItemRegistry.ESSENCE_BOTTLE.get(), ItemRegistry.IMPURE_WITCH_ESSENCE.get(), ItemRegistry.PURE_WITCH_ESSENCE.get());
    }

    private static void addRecipe(ItemLike input, ItemLike ingredient, ItemLike output) {
        addRecipe(input,ingredient,output,1);
    }

    private static void addRecipe(ItemLike input, ItemLike ingredient, ItemLike output, int amount_output) {
        BrewingRecipeRegistry.addRecipe(Ingredient.of(input), Ingredient.of(ingredient), new ItemStack(output,amount_output));
    }
}
