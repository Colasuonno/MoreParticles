package com.mr_replete.particles.lib.expressions;

import com.mr_replete.particles.lib.EffectDisplay;
import com.mr_replete.particles.lib.ParticleEffect;
import com.mr_replete.particles.lib.ParticleType;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Dick extends Expression {

    public Dick() {
        super("dick");
    }

    @Override
    public void draw(Player sender, ParticleEffect effect) {
        final Location secondBall = effect.getLocation().clone().add(4.0D,0.0D,0.0D);
        Circle circle = new Circle(2,360);
        Circle circle2 = new Circle(2,360);
        circle.draw(sender,effect);
        circle2.draw(sender, new ParticleEffect(secondBall, ParticleType.DRAGON_BREATH,0.0f,0.0f,0.0f,0,10));
        for (double x = 1.5; x < 3; x+=0.5){
            for (double z = 3; z < 11; z++){
                new EffectDisplay().draw(sender,ParticleType.DRAGON_BREATH,0.0f,0.0f,0.0f,0,100,new Location(effect.getLocation().getWorld(),effect.getLocation().getX()+x,effect.getLocation().getY(),effect.getLocation().getZ()+z));
            }
        }
        for (double x = 1.5; x < 3; x+=0.5){
            new EffectDisplay().draw(sender,ParticleType.CLOUD,1.0f,1.0f,1.0f,1,20,new Location(effect.getLocation().getWorld(),effect.getLocation().getX()+x,effect.getLocation().getY(),effect.getLocation().getZ()+10));
        }
    }
}
