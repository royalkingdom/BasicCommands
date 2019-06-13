package de.tlph1.commands;

import java.util.ArrayList;
import java.util.List;

import de.tlph1.util.ConfigWerte;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Vanish implements CommandExecutor {

    public static List<Player> vanished = new ArrayList<Player>();

    private ConfigWerte cw;

    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        cw = new ConfigWerte();
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("bc.vanish")){
                if (args.length == 0) {
                    if (vanished.contains(p)) {
                        vanished.remove(p);
                        ConfigWerte.playerMessage(p,cw.Prefix + cw.Sichtbar);
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.showPlayer(p);
                        }
                    } else {
                        vanished.add(p);
                        ConfigWerte.playerMessage(p,cw.Prefix + cw.Unsichtbar);
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (!all.hasPermission("bc.vanish.see")) {
                                all.hidePlayer(p);
                            }
                        }
                    }
                }
            }
            else
                ConfigWerte.playerMessage(p, cw.Prefix + cw.NoPerm);
        }else
            ConfigWerte.consoleMessage(cw.Prefix + cw.PlayerCommand);
        return false;
    }
}