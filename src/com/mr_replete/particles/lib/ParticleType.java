package com.mr_replete.particles.lib;

import com.mr_replete.particles.MoreParticles;
import com.mr_replete.particles.exceptions.WrongVersionException;
import com.mr_replete.particles.reflection.ReflectionUtil;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public enum ParticleType {

    EXPLOSION_NORMAL("explode", 0, 0),
    EXPLOSION_LARGE("largeexplode", 1, 0),
    EXPLOSION_HUGE("hugeexplosion", 2, 0),
    FIREWORKS_SPARK("fireworksSpark", 3, 0),
    WATER_BUBBLE("bubble", 4, 0),
    WATER_SPLASH("splash", 5, 0),
    WATER_WAKE("wake", 6, 0),
    SUSPENDED("suspended", 7, 0),
    SUSPENDED_DEPTH("depthsuspend", 8, 0),
    CRIT("crit", 9, 0),
    CRIT_MAGIC("magicCrit", 10, 0),
    SMOKE_NORMAL("smoke", 11, 0),
    SMOKE_LARGE("largesmoke", 12, 0),
    SPELL("spell", 13, 0),
    SPELL_INSTANT("instantSpell", 14, 0),
    SPELL_MOB("mobSpell", 15, 0),
    SPELL_MOB_AMBIENT("mobSpellAmbient", 16, 0),
    SPELL_WITCH("witchMagic", 17, 0),
    DRIP_WATER("dripWater", 18, 0),
    DRIP_LAVA("dripLava", 19, 0),
    VILLAGER_ANGRY("angryVillager", 20, 0),
    VILLAGER_HAPPY("happyVillager", 21, 0),
    TOWN_AURA("townaura", 22, 0),
    NOTE("note", 23, 0),
    PORTAL("portal", 24, 0),
    ENCHANTMENT_TABLE("enchantmenttable", 25, 0),
    FLAME("flame", 26, 0),
    LAVA("lava", 27, 0),
    FOOTSTEP("footstep", 28, 0),
    CLOUD("cloud", 29, 0),
    REDSTONE("reddust", 30, 0),
    SNOWBALL("snowballpoof", 31, 0),
    SNOW_SHOVEL("snowshovel", 32, 0),
    SLIME("slime", 33, 0),
    HEART("heart", 34, 0),
    BARRIER("barrier", 35, 0),
    ITEM_CRACK("iconcrack", 36, 0),
    BLOCK_CRACK("blockcrack", 37, 0),
    BLOCK_DUST("blockdust", 38, 0),
    WATER_DROP("droplet", 39, 0),
    ITEM_TAKE("take", 40, 0),
    MOB_APPEARANCE("mobappearance", 41, 0),
    DRAGON_BREATH("dragonbreath", 42, 1),
    END_ROD("endRod", 43, 1),
    DAMAGE_INDICATOR("damageIndicator", 44, 1),
    SWEEP_ATTACK("sweepAttack", 45, 1),
    FALLING_DUST("fallingdust", 46, 1),
    TOTEM("totem", 47, 1),
    SPIT("spit", 48, 1);


    private String name;
    private int id;
    private int version;
    private double range;

    /**
     * Versions:
     * 0: 1.8
     * 1: 1.11-1.12.2
     * @param name
     * @param id
     * @param version
     */
    ParticleType(String name, int id, int version) {
        this.name = name;
        this.id = id;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public double getRange() {
        return range;
    }

    /**
     * Send Player particles by type
     * @param offsetX
     * @param offsetY
     * @param offsetZ
     * @param speed
     * @param amount
     * @param location
     * @param range
     * @throws WrongVersionException
     */
    public void send(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location location, double range) throws WrongVersionException{
        Validate.notNull(location,"Location cannot be null");
        if (MoreParticles.getCurrentVersion() < this.version){
            throw new WrongVersionException("Wrong version");
        }
        this.range = range;
        range *= range;
        for (Player op : Bukkit.getOnlinePlayers()){
            if (location.distanceSquared(op.getLocation()) <= range){
                new EffectDisplay().draw(op,this,offsetX,offsetY,offsetZ,speed,amount,location);
            }
        }
    }

    public ParticleEffect getParticle(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location location) throws WrongVersionException{
        Validate.notNull(location,"Location cannot be null");
        if (MoreParticles.getCurrentVersion() < this.version){
            throw new WrongVersionException("Wrong version");
        }
        return new ParticleEffect(location,this,offsetX,offsetY,offsetZ,speed,amount);
    }

    /**
     * Get bukkkit effect of ParticleType
     * @return
     * @throws WrongVersionException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public Object getBukkitEffect() throws WrongVersionException,NoSuchMethodException,IllegalAccessException,InvocationTargetException{
        int id = getId();
        if (id > 42 && MoreParticles.getCurrentVersion() == 0){
            throw new WrongVersionException("Cannot get Bukkit Effect (Wron  Version)");
        } else{
            Class<?> enumParticles = ReflectionUtil.getNMSClass("EnumParticle");
           return ReflectionUtil.invokeMethod(enumParticles,ReflectionUtil.getMethod(enumParticles,"a",int.class),getId());
        }
    }

    /**
     * Get ParticleType from name
     * @param name
     * @return
     */
    public static ParticleType fromName(String name){
      return Arrays.stream(values())
              .filter(x->x.getName().equalsIgnoreCase(name))
              .collect(Collectors.toList()).get(0);
    }



}
