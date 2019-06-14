package de.tlph1.util;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerDeathEvent event)
    {
        Player p = event. getEntity();
        event.setDeathMessage("§e" + p.getDisplayName() + " §cist von uns gegangen");

    }
}
