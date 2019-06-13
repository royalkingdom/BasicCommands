package de.tlph1.events;

import de.tlph1.util.ConfigWerte;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    private ConfigWerte cw;

   @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        cw = new ConfigWerte();
        Player p = event.getPlayer();
        event.setJoinMessage(cw.Prefix + cw.JoinMessage.replace("%player%", p.getDisplayName()));
    }

}
