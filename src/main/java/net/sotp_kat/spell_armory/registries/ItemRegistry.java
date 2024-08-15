package net.sotp_kat.spell_armory.registries;

import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sotp_kat.spell_armory.SpellArmory;
import net.sotp_kat.spell_armory.items.armor.WitchArmorItem;
import net.sotp_kat.spell_armory.items.armor.SpellArmorMaterials;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SpellArmory.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> WITCH_HAT = ITEMS.register("witch_hat",
            () -> new WitchArmorItem(SpellArmorMaterials.WITCH, ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
    public static final RegistryObject<Item> WITCH_CHESTPLATE = ITEMS.register("witch_chestplate",
            () -> new WitchArmorItem(SpellArmorMaterials.WITCH, ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
    public static final RegistryObject<Item> WITCH_LEGGINGS = ITEMS.register("witch_leggings",
            () -> new WitchArmorItem(SpellArmorMaterials.WITCH, ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
    public static final RegistryObject<Item> WITCH_BOOTS = ITEMS.register("witch_boots",
            () -> new WitchArmorItem(SpellArmorMaterials.WITCH, ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

    public static final RegistryObject<Item> ESSENCE_BOTTLE = ITEMS.register("essence_bottle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMPURE_WITCH_ESSENCE = ITEMS.register("impure_witch_essence",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PURE_WITCH_ESSENCE = ITEMS.register("pure_witch_essence",
            () -> new Item(new Item.Properties()));
}
