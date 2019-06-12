package de.tlph1.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Night implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender instanceof Player){
            if(p.hasPermission("bc.time")){
                if(args.length == 0) {
                    p.getWorld().setTime(15000);
                    p.sendMessage("§aDie bricht nun herrein");
                }else
                    p.sendMessage("Bitte benutze /help NIGHT");
            }else
                p.sendMessage("§cDu hast nicht die benötigten Rechte für diesen Befehl !");
        }else
            sender.sendMessage("Dieser Befehl darf man nur als Spieler ausführen !");

        return false;
    }
}
