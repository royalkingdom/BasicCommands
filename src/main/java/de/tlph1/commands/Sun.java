package de.tlph1.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sun implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender instanceof Player){
            if(p.hasPermission("bc.weather")){
                if(args.length == 0){
                    p.getLocation().getWorld().setStorm(false);
                    p.getLocation().getWorld().setThundering(false);
                    Bukkit.broadcastMessage("§eDie Sonne erscheint !");
                }else
                    p.sendMessage("§cBitte benutze /help RAIN");

            }else
                p.sendMessage("§cDu hast nicht die benötigten Rechte für diesen Befehl !");
        }else
            sender.sendMessage("§cDieser Befehl kann man nur als Spieler ausführen !");
        return false;
    }
}