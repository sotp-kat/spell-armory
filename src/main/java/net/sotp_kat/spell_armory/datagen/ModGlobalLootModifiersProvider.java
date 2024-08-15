package net.sotp_kat.spell_armory.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.sotp_kat.spell_armory.SpellArmory;
import net.sotp_kat.spell_armory.loot.AddItemModifier;
import net.sotp_kat.spell_armory.registries.ItemRegistry;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, SpellArmory.MODID);
    }

    @Override
    protected void start() {
        add("impure_witch_essence_from_witch", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/witch")).build(),
                LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.10f,0.10f).build()
        }, ItemRegistry.IMPURE_WITCH_ESSENCE.get()));
    }
}
