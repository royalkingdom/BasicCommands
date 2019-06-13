package de.tlph1.util;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
            Player p = event.getPlayer();
            event.setJoinMessage("§e" + p.getDisplayName() + " §aist dem Königreich beigetreten");

    }

}
