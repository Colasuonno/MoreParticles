package com.mr_replete.particles.lib.expressions;

import com.mr_replete.particles.lib.EffectDisplay;
import com.mr_replete.particles.lib.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Cycloid extends Expression {

    private int r;

    public Cycloid(int r) {
        super("cycloid");
        this.r = r;
    }

    @Override
    public void draw(Player sender, ParticleEffect effect) {
        for (double i = 0; i < 360; i+= 0.5){
            double x = r*(i-Math.sin(i));
            double y = r*(1-Math.cos(i));
            new EffectDisplay().draw(effect,new Location(effect.getLocation().getWorld(),effect.getLocation().getX()+x,effect.getLocation().getY()+y,effect.getLocation().getZ()),sender);
        }
    }
}
