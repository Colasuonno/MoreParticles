package com.mr_replete.particles.lib;

import com.mr_replete.particles.reflection.ReflectionUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class EffectDisplay {

    /**
     * Draw particle using reflection 1.8-1.12.2
      * @param player
     * @param type
     * @param offsetX
     * @param offsetY
     * @param offsetZ
     * @param speed
     * @param amnt
     * @param center
     * @see #draw(ParticleEffect, Location, Player)
     */
    public void draw(Player player,ParticleType type, float offsetX,float offsetY,float offsetZ,float speed,int amnt,Location center){
        try {
            Object packet = ReflectionUtil.newConstructorInstance(ReflectionUtil.getConstructor(ReflectionUtil.getNMSClass("PacketPlayOutWorldParticles")));
            ReflectionUtil.setFieldValue("a",packet, type.getBukkitEffect());
            ReflectionUtil.setFieldValue("b",packet, (float)center.getX());
            ReflectionUtil.setFieldValue("c",packet, (float)center.getY());
            ReflectionUtil.setFieldValue("d",packet, (float)center.getZ());
            ReflectionUtil.setFieldValue("e",packet, offsetX);
            ReflectionUtil.setFieldValue("f",packet, offsetY);
            ReflectionUtil.setFieldValue("g",packet, offsetZ);
            ReflectionUtil.setFieldValue("h",packet, speed);
            ReflectionUtil.setFieldValue("i",packet, amnt);
            ReflectionUtil.sendPacket(packet,player);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Draw particle using reflection 1.8-1.12.2
     * @param effect
     * @param player
     * @see #draw(Player, ParticleType, float, float, float, float, int, Location)
     */
    public void draw(ParticleEffect effect,Location location, Player player){
        draw(player,effect.getType(),effect.getOffSetX(),effect.getOffSetY(),effect.getOffSetZ(),effect.getSpeed(),effect.getAmnt(),location);
    }

}
