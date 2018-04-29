package com.mr_replete.particles.dev;

import com.mr_replete.particles.MoreParticles;
import com.mr_replete.particles.exceptions.WrongVersionException;
import com.mr_replete.particles.lib.ParticleType;
import com.mr_replete.particles.lib.expressions.*;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class DevCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("devcommand")){
            Expression expression = new Dick();
                    final Location location = ((Player)commandSender).getLocation().clone();
                    new BukkitRunnable(){
                        @Override
                        public void run() {
                            try {
                                expression.draw((Player)commandSender,ParticleType.DRAGON_BREATH.getParticle(0F,0F,0F,0,10,location));
                            } catch (WrongVersionException e){
                                e.printStackTrace();
                            }
                        }
                    }.runTaskTimer(MoreParticles.getInstance(),0L,20L);
                }

        return true;
    }
}
