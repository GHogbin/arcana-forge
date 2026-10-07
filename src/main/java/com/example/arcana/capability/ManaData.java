package com.example.arcana.capability;
import net.minecraft.nbt.CompoundTag;
public class ManaData {
    private float mana = 100, max = 100; private int skillPoints, boltRangeLevel, lastLevel;
    public float get() { return mana; } public float max() { return max; }
    public void set(float value) { mana = Math.max(0, Math.min(max, value)); }
    public void tick() { if (mana < max) set(mana + 0.0833333f); }
    public int skillPoints(){return skillPoints;} public int boltRangeLevel(){return boltRangeLevel;} public void addSkillPoints(int n){skillPoints+=Math.max(0,n);} public boolean spendSkillPoint(){if(skillPoints<=0)return false;skillPoints--;return true;} public void upgradeBoltRange(){if(spendSkillPoint())boltRangeLevel++;}
    public void upgradeMaxMana(){if(spendSkillPoint()){max+=10;set(max);}}
    public void checkLevel(int level){if(lastLevel==0)lastLevel=level;while(level>lastLevel){skillPoints++;lastLevel++;}}
    public CompoundTag save() { var t = new CompoundTag(); t.putFloat("mana", mana); t.putFloat("max", max); t.putInt("skill_points",skillPoints); t.putInt("bolt_range_level",boltRangeLevel); t.putInt("last_level",lastLevel); return t; }
    public void load(CompoundTag t) { max=t.getFloat("max"); if(max<=0)max=100; set(t.getFloat("mana")); skillPoints=t.getInt("skill_points"); boltRangeLevel=t.getInt("bolt_range_level"); lastLevel=t.getInt("last_level"); }
}
