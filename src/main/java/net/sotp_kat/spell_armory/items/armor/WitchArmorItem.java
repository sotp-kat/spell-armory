package net.sotp_kat.spell_armory.items.armor;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.sotp_kat.spell_armory.entity.armor.witch.WitchArmorRenderer;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class WitchArmorItem extends ArmorItem implements GeoItem, ShouldDisableCape {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final SpellArmorMaterials material;

    public WitchArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
        this.material = (SpellArmorMaterials) material;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private WitchArmorRenderer renderer;
            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null) this.renderer = new WitchArmorRenderer();

                this.renderer.prepForRender(livingEntity,itemStack,equipmentSlot,original);
                return this.renderer;
            }
        });
    }

    private PlayState predicate(AnimationState<WitchArmorItem> animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,"controller",20,this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot pEquipmentSlot) {
        if (pEquipmentSlot == this.type.getSlot()) {
            try{
                ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
                float defense = material.getDefenseForType(this.type);
                float toughness = material.getToughness();
                float knockbackResistance = material.getKnockbackResistance();
                UUID uuid = material.getUuidForSlot(pEquipmentSlot);
                builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier",
                        defense, AttributeModifier.Operation.ADDITION));
                builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor toughness",
                        toughness, AttributeModifier.Operation.ADDITION));
                if (knockbackResistance > 0)
                {
                    builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance",
                            knockbackResistance, AttributeModifier.Operation.ADDITION));
                }
                for (Map.Entry<Attribute, AttributeModifier> modifierEntry : material.getAdditionalAttributes().entrySet())
                {
                    AttributeModifier atr = modifierEntry.getValue();
                    atr = new AttributeModifier(uuid, atr.getName(), atr.getAmount(), atr.getOperation());
                    builder.put(modifierEntry.getKey(), atr);
                }
                return builder.build();
            }catch (Exception configNotLoaded){
                return ImmutableMultimap.of();
            }
        }
        else
        {
            return ImmutableMultimap.of();
        }
    }

    @Override
    public ArrayList<EquipmentSlot> forSlots() {
        ArrayList<EquipmentSlot> slots = new ArrayList<>();
        slots.add(EquipmentSlot.CHEST);
        return slots;
    }
}
