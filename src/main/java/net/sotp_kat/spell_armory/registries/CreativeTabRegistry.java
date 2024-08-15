package net.sotp_kat.spell_armory.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sotp_kat.spell_armory.SpellArmory;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SpellArmory.MODID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("spell_armory_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.translatable("tab.spell_armory.main"))
            .icon(() -> ItemRegistry.WITCH_HAT.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ItemRegistry.WITCH_HAT.get());
                output.accept(ItemRegistry.WITCH_CHESTPLATE.get());
                output.accept(ItemRegistry.WITCH_LEGGINGS.get());
                output.accept(ItemRegistry.WITCH_BOOTS.get());
                output.accept(ItemRegistry.ESSENCE_BOTTLE.get());
                output.accept(ItemRegistry.IMPURE_WITCH_ESSENCE.get());
                output.accept(ItemRegistry.PURE_WITCH_ESSENCE.get());
            }).build());
}
