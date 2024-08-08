package net.sotp_kat.spell_armory.items.client;

import net.minecraft.resources.ResourceLocation;
import net.sotp_kat.spell_armory.SpellArmory;
import net.sotp_kat.spell_armory.items.armor.LargeWitchArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class LargeWitchArmorModel extends GeoModel<LargeWitchArmorItem> {
    @Override
    public ResourceLocation getModelResource(LargeWitchArmorItem largeWitchArmorItem) {
        return new ResourceLocation(SpellArmory.MODID,"geo/large_witch_helmet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LargeWitchArmorItem largeWitchArmorItem) {
        return new ResourceLocation(SpellArmory.MODID,"textures/armor/large_witch_helmet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LargeWitchArmorItem largeWitchArmorItem) {
        return new ResourceLocation(SpellArmory.MODID,"animations/large_witch_helmet.animation.json");
    }
}
