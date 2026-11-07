package com.example.beetlebrass;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class BeetleBrassMod implements ModInitializer {
    public static final String MOD_ID = "beetle_brass";
    public static final Item BEETLE_BRASS = register("beetle_brass", new Item(new Item.Settings()));
    public static final Item LONGSWORD = register("beetle_brass_longsword", WeaponItems.longsword());
    public static final Item GREAT_AXE = register("beetle_brass_great_axe", WeaponItems.greatAxe());

    @Override
    public void onInitialize() {
    }

    private static Item register(String path, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, path), item);
    }
}
