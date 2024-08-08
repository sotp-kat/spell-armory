package net.sotp_kat.spell_armory;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sotp_kat.spell_armory.registries.CreativeTabRegistries;
import net.sotp_kat.spell_armory.registries.ItemRegistries;

@Mod(SpellArmory.MODID)
public class SpellArmory {

    public static final String MODID = "spell_armory";

    public SpellArmory() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistries.register(modEventBus);

        CreativeTabRegistries.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}
