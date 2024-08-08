package net.sotp_kat.spell_armory.items.client;

import net.sotp_kat.spell_armory.items.armor.LargeWitchArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class LargeWitchArmorRenderer extends GeoArmorRenderer<LargeWitchArmorItem> {
    public LargeWitchArmorRenderer() {
        super(new LargeWitchArmorModel());
    }
}
