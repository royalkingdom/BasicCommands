package de.tlph1.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Vanish implements CommandExecutor {

    public static List<Player> vanished = new ArrayList<Player>();


    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("bc.vanish")){
                if (args.length == 0) {
                    if (vanished.contains(p)) {
                        vanished.remove(p);
                      p.sendMessage("§cDu bist nun Sichtbar");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.showPlayer(p);
                        }
                    } else {
                        vanished.add(p);
                        p.sendMessage("§aDu bist nun unsichtbar");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (!all.hasPermission("bc.vanish.see")) {
                                all.hidePlayer(p);
                            }
                        }
                    }
                }
            }
            else
                p.sendMessage("§cDu hast nich die benötigten Rechte für diesen Befehl");
        }else
            Bukkit.getConsoleSender().sendMessage("§cDieser Befehl kann man nur als Spieler ausfuehren");
        return false;
    }
}