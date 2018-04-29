package com.mr_replete.particles.lib.expressions;

import com.mr_replete.particles.lib.EffectDisplay;
import com.mr_replete.particles.lib.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Hypotrochoid extends Expression {

    public Hypotrochoid() {
        super("hypotrochoid");
    }

    @Override
    public void draw(Player sender, ParticleEffect effect) {
        double R = 5;
        double r = 3;
        double d = 5;
       for (double i = 0; i < 360; i++){
            double x = (R-r)*Math.cos(i)+d*Math.cos(((R-r)/r)*i);
            double y = (R-r)*Math.sin(i)-d*Math.sin(((R-r)/r)*i);
            new EffectDisplay().draw(effect,new Location(effect.getLocation().getWorld(),effect.getLocation().getX()+x,effect.getLocation().getY()+y,effect.getLocation().getZ()),sender);
        }
    }
}
