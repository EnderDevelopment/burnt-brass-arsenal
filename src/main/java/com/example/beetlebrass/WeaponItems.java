package com.example.beetlebrass;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

final class WeaponItems {
    private WeaponItems() {
    }

    static Item longsword() {
        return weapon(10.0, -2.5, "beetle_brass_longsword");
    }

    static Item greatAxe() {
        return weapon(15.0, -3.4, "beetle_brass_great_axe");
    }

    private static Item weapon(double damage, double speed, String id) {
        Item.Settings settings = new Item.Settings().maxCount(1);
        AttributeModifiersComponent modifiers = AttributeModifiersComponent.builder()
                .add(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(
                        Identifier.of(BeetleBrassMod.MOD_ID, id + "_damage"), damage - 1.0,
                        EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(
                        Identifier.of(BeetleBrassMod.MOD_ID, id + "_speed"), speed + 4.0,
                        EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .build();
        settings.component(DataComponentTypes.ATTRIBUTE_MODIFIERS, modifiers);
        settings.repairable(BeetleBrassMod.BEETLE_BRASS);
        return new Item(settings);
    }
}
