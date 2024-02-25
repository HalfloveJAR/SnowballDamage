package net.halflove.snowballdamage;

import java.io.File;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    Double snowballDamage;
    Double eggDamage;

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "SBD: Snowball Damage Version: " + getDescription().getVersion() + ChatColor.GREEN + " By Halflove Enabled!");
        getServer().getPluginManager().registerEvents(this, this);
        snowballDamage = getConfig().getDouble("Snowballs.Damage");
        eggDamage = getConfig().getDouble("Eggs.Damage");
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onEntityHit(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof org.bukkit.entity.Snowball)
            e.setDamage(snowballDamage);
        if (e.getDamager() instanceof org.bukkit.entity.Egg)
            e.setDamage(eggDamage);
    }
}
