package net.sotp_kat.spell_armory.datagen;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.sotp_kat.spell_armory.registries.ItemRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemRegistry.WITCH_HAT.get())
                .pattern("###")
                .pattern("#@#")
                .define('#', io.redspace.ironsspellbooks.registries.ItemRegistry.MAGIC_CLOTH.get())
                .define('@', ItemRegistry.PURE_WITCH_ESSENCE.get())
                .group("spell_armor")
                .unlockedBy("ink_legendary", has(io.redspace.ironsspellbooks.registries.ItemRegistry.INK_LEGENDARY.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemRegistry.WITCH_CHESTPLATE.get())
                .pattern("#@#")
                .pattern("###")
                .pattern("###")
                .define('#', io.redspace.ironsspellbooks.registries.ItemRegistry.MAGIC_CLOTH.get())
                .define('@', ItemRegistry.PURE_WITCH_ESSENCE.get())
                .group("spell_armor")
                .unlockedBy("ink_legendary", has(io.redspace.ironsspellbooks.registries.ItemRegistry.INK_LEGENDARY.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemRegistry.WITCH_LEGGINGS.get())
                .pattern("###")
                .pattern("#@#")
                .pattern("# #")
                .define('#', io.redspace.ironsspellbooks.registries.ItemRegistry.MAGIC_CLOTH.get())
                .define('@', ItemRegistry.PURE_WITCH_ESSENCE.get())
                .group("spell_armor")
                .unlockedBy("ink_legendary", has(io.redspace.ironsspellbooks.registries.ItemRegistry.INK_LEGENDARY.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemRegistry.WITCH_BOOTS.get())
                .pattern("#@#")
                .pattern("# #")
                .define('#', io.redspace.ironsspellbooks.registries.ItemRegistry.MAGIC_CLOTH.get())
                .define('@', ItemRegistry.PURE_WITCH_ESSENCE.get())
                .group("spell_armor")
                .unlockedBy("ink_legendary", has(io.redspace.ironsspellbooks.registries.ItemRegistry.INK_LEGENDARY.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, ItemRegistry.ESSENCE_BOTTLE.get())
                .pattern(" @ ")
                .pattern("# #")
                .pattern(" # ")
                .define('#', Tags.Items.GLASS_TINTED)
                .define('@', Tags.Items.OBSIDIAN)
                .group("spell_armor")
                .unlockedBy("glass_tinted", has(Tags.Items.GLASS_TINTED))
                .save(consumer);
    }
}
