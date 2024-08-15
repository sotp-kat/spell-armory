package net.sotp_kat.spell_armory;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sotp_kat.spell_armory.registries.BrewingRegistry;
import net.sotp_kat.spell_armory.registries.CreativeTabRegistry;
import net.sotp_kat.spell_armory.registries.ItemRegistry;
import net.sotp_kat.spell_armory.registries.LootModifierRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(SpellArmory.MODID)
public class SpellArmory {

    public static final Logger LOGGER = LogManager.getLogger(SpellArmory.MODID); //LogUtils.getLogger();

    public static final String MODID = "spell_armory";

    public SpellArmory() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(modEventBus);
        CreativeTabRegistry.register(modEventBus);

        LootModifierRegistry.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final @NotNull FMLCommonSetupEvent event) {
        event.enqueueWork(BrewingRegistry::register);
    }
}
