package net.sotp_kat.spell_armory.entity.armor.witch;

import net.sotp_kat.spell_armory.items.armor.WitchArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class WitchArmorRenderer extends GeoArmorRenderer<WitchArmorItem> {
    public WitchArmorRenderer() {
        super(new WitchArmorModel());
    }
}
