package com.mr_replete.particles.lib.expressions;

import com.mr_replete.particles.lib.EffectDisplay;
import com.mr_replete.particles.lib.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Hypocycloid extends Expression {

    private double r;
    private double k;

    public Hypocycloid(double r, double k) {
        super("hypocycloid");
        this.r = r;
        this.k = k;
    }

    @Override
    public void draw(Player sender, ParticleEffect effect) {
        for (double i = 0; i < 360; i+= 0.7) {
            double x = r*(k-1)*Math.cos(i)+r*Math.cos((k-1)*i);
            double y = r*(k-1)*Math.sin(i)-r*Math.sin((k-1)*i);
            new EffectDisplay().draw(effect,new Location(effect.getLocation().getWorld(),effect.getLocation().getX()+x,effect.getLocation().getY()+y,effect.getLocation().getZ()),sender);
        }
    }
}
