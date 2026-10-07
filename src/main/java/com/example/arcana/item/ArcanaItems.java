package com.example.arcana.item;
import com.example.arcana.Arcana;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.*;
public final class ArcanaItems {
 public static final DeferredRegister<Item> ITEMS=DeferredRegister.create(ForgeRegistries.ITEMS,Arcana.MOD_ID);
 public static final RegistryObject<Item> MANA_CRYSTAL=basic("mana_crystal");
 public static final RegistryObject<Item> SAGES_RING=basic("sages_ring");
 public static final RegistryObject<Item> ARCANE_FOCUS=basic("arcane_focus");
 public static final RegistryObject<Item> BLINKSTONE=basic("blinkstone");
 public static final RegistryObject<Item> WARD_SIGIL=basic("ward_sigil");
 private static RegistryObject<Item> basic(String id){return ITEMS.register(id,()->new Item(new Item.Properties().stacksTo(1)));}
}
