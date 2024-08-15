package net.sotp_kat.spell_armory.items.armor;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.sotp_kat.spell_armory.SpellArmory;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

public enum SpellArmorMaterials implements ArmorMaterial {
    WITCH("witch",26,new int[]{1,3,2,1},50, SoundEvents.ARMOR_EQUIP_LEATHER,
            0f, 0f,() -> Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
            Map.of(AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("spell_power", 0.125, AttributeModifier.Operation.MULTIPLY_TOTAL),
            AttributeRegistry.MANA_REGEN.get(), new AttributeModifier("mana_regen", 0.25, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.MAX_MANA.get(), new AttributeModifier("max_mana", 100, AttributeModifier.Operation.ADDITION)));

    private final String name;
    private final int durabilityMultiplier;
    public final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float thoughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;
    private final Map<Attribute, AttributeModifier> additionalAttributes;
    private final UUID[] uuids;

    private static final int[] BASE_DURABILITY = {11,16,15,13};

    SpellArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float thoughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, Map<Attribute, AttributeModifier> additionalAttributes) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.thoughness = thoughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
        this.additionalAttributes = additionalAttributes;
        this.uuids = new UUID[4];
        for (int i = 0; i < uuids.length; i++) uuids[i] = UUID.randomUUID();
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()]*this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public @NotNull String getName() {
        return SpellArmory.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.thoughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public Map<Attribute, AttributeModifier> getAdditionalAttributes() {
        return additionalAttributes;
    }

    public UUID getUuidForSlot(EquipmentSlot equipmentSlot) {
        try {
            return uuids[equipmentSlot.getIndex()];
        } catch (ArrayIndexOutOfBoundsException e) {
            SpellArmory.LOGGER.error(e.getMessage());
            return UUID.randomUUID();
        }
    }
}
