package net.sotp_kat.spell_armory.mixin;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.sotp_kat.spell_armory.items.armor.ShouldDisableCape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayer.class)
public class CapeSupressionMixin {

    @Inject(method = "isCapeLoaded", at = @At("HEAD"), cancellable = true)
    public void disableCapeOnCheck(CallbackInfoReturnable<Boolean> cir) {
        Inventory inventory = ((Player) (Object) this).getInventory();
        for (ItemStack slot:inventory.armor) {
            Item item = slot.getItem();
            if (item instanceof ShouldDisableCape toDisable) {
                if (toDisable.forSlots().contains(LivingEntity.getEquipmentSlotForItem(slot))) {
                    cir.setReturnValue(false);
                }
            }
        }
    }
}
