package com.mr_replete.particles.lib.expressions;

import com.mr_replete.particles.lib.EffectDisplay;
import com.mr_replete.particles.lib.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Butterfly extends Expression {

    public Butterfly() {
        super("butterfly");
    }

    @Override
    public void draw(Player sender, ParticleEffect effect) {
        for (int t = 0; t < 360; t++){
            double x = Math.sin(t)*(Math.pow(Math.E,Math.cos(t))-2*Math.cos(4*t)-Math.pow(Math.sin(t/12),5));
            double y = Math.cos(t)*(Math.pow(Math.E,Math.cos(t))-2*Math.cos(4*t)-Math.pow(Math.sin(t/12),5));
            new EffectDisplay().draw(effect,new Location(effect.getLocation().getWorld(),effect.getLocation().getX()+x,effect.getLocation().getY()+y,effect.getLocation().getZ()),sender);
        }
    }
}
