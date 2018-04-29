package com.mr_replete.particles.lib.expressions;

import com.mr_replete.particles.lib.EffectDisplay;
import com.mr_replete.particles.lib.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RightTriangle extends Expression {

    private int a;
    private int b;
    private int c;

    public RightTriangle(int a,int b,int c) {
        super("rightTriangle");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void draw(Player sender, ParticleEffect effect) {
        if (Math.sqrt(a*a+b*b) != c){
            Bukkit.getLogger().info(ChatColor.RED + "That's not a right triangle");
            return;
        }
        drawLineX(effect,sender,a);
        drawLineY(effect,sender,b,a);
        double y;
        for (double x =0; x <= a; x++){
            y = c-(x*(c/a));
            new EffectDisplay().draw(effect,new Location(effect.getLocation().getWorld(),effect.getLocation().getX()+x,effect.getLocation().getY()+y,effect.getLocation().getZ()),sender);
        }

    }

    private void drawLineX(ParticleEffect effect, Player sender,int lenght){
        for (int i = 0; i < lenght; i++){
            double startx = effect.getLocation().getX();
            new EffectDisplay().draw(effect,new Location(effect.getLocation().getWorld(),startx+i,effect.getLocation().getY(),effect.getLocation().getZ()),sender);
        }
    }

    private void drawLineY(ParticleEffect effect, Player sender,int lenght, int xlenght) {
        for (int i = 1; i < lenght; i++) {
            new EffectDisplay().draw(effect, new Location(effect.getLocation().getWorld(), effect.getLocation().getX(), effect.getLocation().getY()+i, effect.getLocation().getZ()), sender);
        }
    }

}
