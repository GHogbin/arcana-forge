package com.example.arcana;

import com.example.arcana.client.ArcanaClient;
import com.example.arcana.entity.ArcanaEntities;
import com.example.arcana.item.ArcanaItems;
import com.example.arcana.network.ArcanaNetwork;
import com.example.arcana.capability.ManaCapability;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Arcana.MOD_ID)
public final class Arcana {
    public static final String MOD_ID = "arcana";
    public Arcana() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ArcanaEntities.ENTITIES.register(bus);
        ArcanaItems.ITEMS.register(bus);
        MinecraftForge.EVENT_BUS.register(new ManaCapability());
        ArcanaNetwork.init();
    }
    public static ResourceLocation id(String path) { return new ResourceLocation(MOD_ID, path); }
}
