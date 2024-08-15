package net.sotp_kat.spell_armory.entity.armor.witch;

import net.minecraft.resources.ResourceLocation;
import net.sotp_kat.spell_armory.SpellArmory;
import net.sotp_kat.spell_armory.items.armor.WitchArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class WitchArmorModel extends GeoModel<WitchArmorItem> {
    @Override
    public ResourceLocation getModelResource(WitchArmorItem witchArmorItem) {
        return new ResourceLocation(SpellArmory.MODID,"geo/witch_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WitchArmorItem witchArmorItem) {
        return new ResourceLocation(SpellArmory.MODID,"textures/armor/witch_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WitchArmorItem witchArmorItem) {
        return new ResourceLocation(SpellArmory.MODID,"animations/witch_armor.animation.json");
    }
}
