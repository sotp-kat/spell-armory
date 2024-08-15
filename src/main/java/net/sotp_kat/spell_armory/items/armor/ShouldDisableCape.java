package net.sotp_kat.spell_armory.items.armor;

import net.minecraft.world.entity.EquipmentSlot;

import java.util.ArrayList;

public interface ShouldDisableCape {
    // interface for disabling cape for armor (per slot)
    public ArrayList<EquipmentSlot> forSlots();
}
