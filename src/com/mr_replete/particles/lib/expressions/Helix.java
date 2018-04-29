package com.mr_replete.particles.lib.expressions;

import com.mr_replete.particles.MoreParticles;
import com.mr_replete.particles.lib.EffectDisplay;
import com.mr_replete.particles.lib.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Helix extends Expression {

    private double r;

    public Helix(double r) {
        super("helix");
        this.r = r;
    }

    @Override
    public void draw(Player sender, ParticleEffect effect) {
        new BukkitRunnable(){
            double i = 0;
            @Override
            public void run() {
                Location location = sender.getLocation();
                i+= Math.PI/8;
                    double x = r*Math.cos(i);
                    double z = r*Math.sin(i);
                    double y = i/4;
                    new EffectDisplay().draw(effect,new Location(effect.getLocation().getWorld(),location.getX()+x,location.getY()+y,location.getZ()+z),sender);
                if (i > 6*Math.PI/2){
                    i = 0;
                }
            }
        }.runTaskTimer(MoreParticles.getInstance(),0L,3L);

    }
}
