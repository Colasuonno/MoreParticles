package com.mr_replete.particles.lib;

import org.bukkit.Location;

public class ParticleEffect {

    private Location location;
    private ParticleType type;
    private float offSetX;
    private float offSetY;
    private float offSetZ;
    private float speed;
    private int amnt;

    public ParticleEffect(Location location, ParticleType type, float offSetX, float offSetY, float offSetZ, float speed, int amnt) {
        this.location = location;
        this.type = type;
        this.offSetX = offSetX;
        this.offSetY = offSetY;
        this.offSetZ = offSetZ;
        this.speed = speed;
        this.amnt = amnt;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ParticleType getType() {
        return type;
    }

    public void setType(ParticleType type) {
        this.type = type;
    }

    public float getOffSetX() {
        return offSetX;
    }

    public void setOffSetX(float offSetX) {
        this.offSetX = offSetX;
    }

    public float getOffSetY() {
        return offSetY;
    }

    public void setOffSetY(float offSetY) {
        this.offSetY = offSetY;
    }

    public float getOffSetZ() {
        return offSetZ;
    }

    public void setOffSetZ(float offSetZ) {
        this.offSetZ = offSetZ;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getAmnt() {
        return amnt;
    }

    public void setAmnt(int amnt) {
        this.amnt = amnt;
    }
}
