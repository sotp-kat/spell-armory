package net.sotp_kat.spell_armory.registries;

import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sotp_kat.spell_armory.SpellArmory;
import net.sotp_kat.spell_armory.items.armor.LargeWitchArmorItem;
import net.sotp_kat.spell_armory.items.armor.SpellArmorMaterials;

public class ItemRegistries {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SpellArmory.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> LARGE_WITCH_HELMET = ITEMS.register("large_witch_helmet",
            () -> new LargeWitchArmorItem(SpellArmorMaterials.LARGE_WITCH, ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
}
