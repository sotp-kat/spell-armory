package net.sotp_kat.spell_armory.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.sotp_kat.spell_armory.SpellArmory;
import net.sotp_kat.spell_armory.registries.ItemRegistry;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SpellArmory.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemRegistry.WITCH_HAT);
        simpleItem(ItemRegistry.WITCH_CHESTPLATE);
        simpleItem(ItemRegistry.WITCH_LEGGINGS);
        simpleItem(ItemRegistry.WITCH_BOOTS);

        simpleItem(ItemRegistry.ESSENCE_BOTTLE);
        simpleItem(ItemRegistry.IMPURE_WITCH_ESSENCE);
        simpleItem(ItemRegistry.PURE_WITCH_ESSENCE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SpellArmory.MODID,"item/"+item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SpellArmory.MODID,"item/"+item.getId().getPath()));
    }
}
