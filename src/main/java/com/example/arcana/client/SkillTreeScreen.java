package com.example.arcana.client;
import com.example.arcana.network.*; import net.minecraft.client.gui.GuiGraphics; import net.minecraft.client.gui.components.Button; import net.minecraft.client.gui.screens.Screen; import net.minecraft.network.chat.Component;
public class SkillTreeScreen extends Screen {
 private int px,py; public SkillTreeScreen(){super(Component.literal("Arcana Skill Tree"));}
 protected void init(){px=width/2-350;py=height/2-215;addRenderableWidget(n("Attunement",px+95,py+150,"attunement"));addRenderableWidget(n("Arcane Bolt",px+315,py+150,"bolt_range"));addRenderableWidget(n("Ward",px+535,py+150,null));addRenderableWidget(n("Blink",px+535,py+305,null));}
 private Button n(String s,int x,int y,String skill){return Button.builder(Component.literal(s),b->{if(skill!=null)ArcanaNetwork.CHANNEL.sendToServer(new UpgradeSkillPacket(skill));}).bounds(x,y,110,34).build();}
 public void render(GuiGraphics g,int mx,int my,float pt){renderBackground(g);int w=700,h=430;g.fill(px,py,px+w,py+h,0xEE171219);g.fill(px+8,py+8,px+w-8,py+h-8,0xE52A202D);g.renderOutline(px,py,w,h,0xFFB47EE8);g.renderOutline(px+4,py+4,w-8,h-8,0xFF604871);
  for(int i=0;i<6;i++){g.fill(px+40+i*105,py-34,px+105+i*105,py+3,0xFF302733);g.renderOutline(px+40+i*105,py-34,65,37,0xFF796684);}
  g.drawCenteredString(font,"✦  ARCANA SKILL TREE  ✦",px+w/2,py+20,0xFFF4E4FF);g.drawString(font,"✦ Skill Points: 3",px+w-145,py+22,0xFFFFD45F);g.drawCenteredString(font,"CORE",px+w/2,py+70,0xFFFFFFFF);
  line(g,px+150,py+135,px+370,py+135,0xFF5B8DFF);line(g,px+370,py+135,px+590,py+135,0xFF83D966);line(g,px+590,py+180,px+590,py+288,0xFF56DDE8);line(g,px+150,py+180,px+150,py+350,0xFF5B8DFF);line(g,px+370,py+180,px+370,py+350,0xFFB45CFF);
  slot(g,px+115,py+110,"✦",0xFF5B9CFF);slot(g,px+335,py+110,"⚡",0xFFB45CFF);slot(g,px+555,py+110,"◇",0xFF82E66A);slot(g,px+555,py+265,"◉",0xFF5CE7F2);
  locked(g,px+70,py+55);locked(g,px+180,py+55);locked(g,px+500,py+55);locked(g,px+610,py+55);locked(g,px+70,py+270);locked(g,px+180,py+270);locked(g,px+335,py+270);locked(g,px+335,py+345);locked(g,px+445,py+345);locked(g,px+610,py+270);locked(g,px+610,py+345);
  g.fill(px+220,py+235,px+405,py+365,0xF51B1426);g.renderOutline(px+220,py+235,185,130,0xFFB45CFF);g.drawString(font,"Arcane Bolt",px+232,py+248,0xFFCC7CFF);g.drawString(font,"1/5",px+232,py+270,0xFFFFFFFF);g.drawString(font,"Hurl a bolt of pure",px+232,py+292,0xFFD8CFDF);g.drawString(font,"arcane energy.",px+232,py+308,0xFFD8CFDF);g.drawString(font,"Next: +8% range",px+232,py+330,0xFF71E57B);g.fill(px+10,py+h-32,px+w-10,py+h-10,0xAA0D0A11);g.drawString(font,"◉  Click to unlock",px+20,py+h-25,0xFFE8DDF2);g.drawString(font,"ESC  Close",px+w-82,py+h-25,0xFFE8DDF2);super.render(g,mx,my,pt);}
 private void slot(GuiGraphics g,int x,int y,String icon,int c){g.fill(x,y,x+70,y+70,0xFF0E0B12);g.renderOutline(x,y,70,70,c);g.renderOutline(x+4,y+4,62,62,c);g.drawCenteredString(font,icon,x+35,y+24,c);}
 private void locked(GuiGraphics g,int x,int y){g.fill(x,y,x+58,y+58,0xFF28252B);g.renderOutline(x,y,58,58,0xFF77727A);g.drawCenteredString(font,"▣",x+29,y+19,0xFF8E8990);}
 private void line(GuiGraphics g,int x1,int y1,int x2,int y2,int c){g.fill(Math.min(x1,x2),Math.min(y1,y2),Math.max(x1,x2)+3,Math.max(y1,y2)+3,c);}
}
