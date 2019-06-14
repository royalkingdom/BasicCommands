package de.tlph1.events;


import de.tlph1.util.ConfigWerte;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {
    private ConfigWerte cw;
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        cw = new ConfigWerte();
        Player p = event. getEntity();
        event.setDeathMessage(ChatColor.translateAlternateColorCodes('&', cw.Prefix + cw.DeathMessage.replace("%player%", p.getDisplayName())));

    }
}
