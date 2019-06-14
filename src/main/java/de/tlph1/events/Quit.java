package de.tlph1.events;

import de.tlph1.util.ConfigWerte;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {

    private ConfigWerte cw;

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        cw = new ConfigWerte();
        Player p = event.getPlayer();
        event.setQuitMessage(ChatColor.translateAlternateColorCodes('&',cw.Prefix + cw.QuitMessage.replace("%player%", p.getDisplayName())));

    }

}

