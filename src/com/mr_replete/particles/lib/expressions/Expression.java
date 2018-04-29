package com.mr_replete.particles.lib.expressions;

import com.mr_replete.particles.exceptions.WrongVersionException;
import com.mr_replete.particles.lib.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public abstract class Expression {

    private String name;
    private ParticleEffect effect;

    public Expression(String name) {
        this.name = name;
    }

    public abstract void draw(Player sender, ParticleEffect effect);

    public String getName() {
        return name;
    }

}


