package com.mr_replete.particles;

import com.mr_replete.particles.dev.DevCommand;
import com.mr_replete.particles.lib.ParticleType;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MoreParticles extends JavaPlugin {

    private static MoreParticles instance;
    private static int currentVersion;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("devcommand").setExecutor(new DevCommand());
        currentVersion = isOnedotEight() ? 0 : 1;
try {
    Bukkit.getLogger().info("BUKKIT EFFECT: " + ParticleType.BARRIER.getBukkitEffect());
} catch (Exception e){
    e.printStackTrace();
}


    }

    public static boolean isOnedotEight(){
        String version = Bukkit.getServer().getClass().getPackage().getName().replace(".",  ",").split(",")[3];
        return version.equalsIgnoreCase("v1_8_R1") || version.equalsIgnoreCase("v1_8_R2") || version.equalsIgnoreCase("v1_8_R3");
    }

    public static int getCurrentVersion() {
        return currentVersion;
    }

    public static MoreParticles getInstance() {
        return instance;
    }
}
