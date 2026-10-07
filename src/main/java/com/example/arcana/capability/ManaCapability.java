package com.example.arcana.capability;
import com.example.arcana.Arcana;
import com.example.arcana.network.ArcanaNetwork;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;

public class ManaCapability {
 public static final Capability<ManaData> TYPE=CapabilityManager.get(new CapabilityToken<>(){});
 private static final ResourceLocation KEY=Arcana.id("mana");
 @SubscribeEvent public void attach(AttachCapabilitiesEvent<net.minecraft.world.entity.Entity> e){if(e.getObject() instanceof net.minecraft.world.entity.player.Player p)e.addCapability(KEY,new Provider());}
 @SubscribeEvent public void tick(TickEvent.PlayerTickEvent e){if(e.phase==TickEvent.Phase.END && !e.player.level().isClientSide && e.player.tickCount%2==0){e.player.getCapability(TYPE).ifPresent(m->{m.tick();m.checkLevel(e.player.experienceLevel); if(e.player.tickCount%10==0)ArcanaNetwork.sync((ServerPlayer)e.player);});}}
 @SubscribeEvent public void clone(PlayerEvent.Clone e){e.getOriginal().getCapability(TYPE).ifPresent(old->e.getEntity().getCapability(TYPE).ifPresent(now->now.load(old.save())));}
 @SubscribeEvent public void joined(PlayerEvent.PlayerLoggedInEvent e){var p=e.getEntity(); if(p.level().isClientSide || p.getPersistentData().getBoolean("arcana_guide_given"))return; ItemStack book=new ItemStack(Items.WRITTEN_BOOK); var tag=book.getOrCreateTag(); tag.putString("title","Arcana Guide"); tag.putString("author","Arcana"); ListTag pages=new ListTag(); pages.add(StringTag.valueOf("{\"text\":\"ARCANA\\n\\nHigh-fantasy spellcasting for Forge 1.20.1.\\n\\nV: Arcane Bolt\\nB: Blink\\nN: Ward\"}")); pages.add(StringTag.valueOf("{\"text\":\"MANA\\n\\nYou begin with 100 mana. Mana regenerates over time and is saved with your character.\\n\\nBolt: 12\\nBlink: 20\\nWard: 18\"}")); pages.add(StringTag.valueOf("{\"text\":\"ARCANE BOLT\\n\\nA glowing, no-gravity magical projectile. It travels 32 blocks by default, with range reserved for future upgrades.\"}")); pages.add(StringTag.valueOf("{\"text\":\"SPELLS\\n\\nBlink teleports up to 12 blocks and checks the path. Ward grants temporary Resistance II. Both spells have cooldowns.\"}")); pages.add(StringTag.valueOf("{\"text\":\"ITEMS\\n\\nMana Crystal\\nSage's Ring\\nArcane Focus\\nBlinkstone\\nWard Sigil\\n\\nThese are the first progression items and will gain crafted effects as the system expands.\"}")); pages.add(StringTag.valueOf("{\"text\":\"MULTIPLAYER\\n\\nCasting is server-authoritative. The server validates mana and cooldowns, performs the action, and syncs mana to every client.\"}")); tag.put("pages",pages); p.getInventory().add(book); p.getPersistentData().putBoolean("arcana_guide_given",true); }
 public static class Provider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag>{final ManaData data=new ManaData(); final LazyOptional<ManaData> opt=LazyOptional.of(()->data); public <T> LazyOptional<T> getCapability(Capability<T> c,Direction d){return c==TYPE?opt.cast():LazyOptional.empty();} public CompoundTag serializeNBT(){return data.save();} public void deserializeNBT(CompoundTag t){data.load(t);}}
}
