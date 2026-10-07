package com.example.arcana.capability;
import net.minecraft.nbt.CompoundTag;
public class ManaData {
    private float mana = 100, max = 100;
    public float get() { return mana; } public float max() { return max; }
    public void set(float value) { mana = Math.max(0, Math.min(max, value)); }
    public void tick() { if (mana < max) set(mana + 0.0833333f); }
    public CompoundTag save() { var t = new CompoundTag(); t.putFloat("mana", mana); t.putFloat("max", max); return t; }
    public void load(CompoundTag t) { max=t.getFloat("max"); if(max<=0)max=100; set(t.getFloat("mana")); }
}
