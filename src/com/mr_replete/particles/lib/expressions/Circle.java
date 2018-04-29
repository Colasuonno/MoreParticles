package com.mr_replete.particles.lib.expressions;

import com.mr_replete.particles.exceptions.WrongVersionException;
import com.mr_replete.particles.lib.EffectDisplay;
import com.mr_replete.particles.lib.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Circle extends Expression {

    private int r;
    private int amount;

    public Circle(int r, int amnt) {
        super("circle");
        this.r = r;
        this.amount = amnt;
    }

    @Override
    public void draw(Player sender, ParticleEffect effect) {
        for (double i = 0; i < amount; i++){
            double x = r*Math.cos(i) + effect.getLocation().getX();
            double z = r*Math.sin(i) + effect.getLocation().getZ();
            new EffectDisplay().draw(effect,new Location(effect.getLocation().getWorld(),x,effect.getLocation().getY(),z),sender);
        }
    }
}
