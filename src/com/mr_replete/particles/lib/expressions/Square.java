package com.mr_replete.particles.lib.expressions;

import com.mr_replete.particles.lib.EffectDisplay;
import com.mr_replete.particles.lib.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Square extends Expression{

    private int l;

    public Square(int l) {
        super("square");
        this.l = l;
    }

    @Override
    public void draw(Player sender, ParticleEffect effect) {
        for (int x = -1; x < l-1; x++){
            for (int z = -1; z < l-1; z++){
                new EffectDisplay().draw(effect,new Location(effect.getLocation().getWorld(),effect.getLocation().getX()+x,effect.getLocation().getY(),effect.getLocation().getZ()+z),sender);
            }
        }
    }
}
