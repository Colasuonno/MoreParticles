package com.mr_replete.particles.lib.expressions;

import com.mr_replete.particles.lib.EffectDisplay;
import com.mr_replete.particles.lib.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Cube extends Expression {

    private int l;

    public Cube(int l) {
        super("cube");
        this.l = l;
    }

    @Override
    public void draw(Player sender, ParticleEffect effect) {
        for (double x = effect.getLocation().getX()-l/2; x < effect.getLocation().getX()+l/2; x++) {
            for (double z = effect.getLocation().getZ()-l/2; z < effect.getLocation().getZ()+l/2; z++) {
                for (double y = effect.getLocation().getY()-l/2; y < effect.getLocation().getY()+l/2; y++)
                    new EffectDisplay().draw(effect, new Location(effect.getLocation().getWorld(), x, y, z), sender);
            }
        }
    }

}
