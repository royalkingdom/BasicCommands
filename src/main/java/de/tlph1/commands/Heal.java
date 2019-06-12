package de.tlph1.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("bc.heal")) {
                if(args.length == 0) {
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    p.sendMessage("§aDu wurdest geheilt");
                }
                else if(args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null && p != target) {
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        target.sendMessage("§aDu wurdest von §6" + p.getName() + " §ageheilt.");
                        p.sendMessage("§aDu hast den Spieler §6" + target.getName() + " §ageheilt.");
                    }else
                        p.sendMessage("§cDer Spieler §6" +  args[0] + "§c ist nicht online.");
                }else
                    p.sendMessage("§cBitte Benutze §6/heal <SPIELER>§c");

            }
            else
                p.sendMessage("§cDu besitzt keine Rechte für diesen Befehl");

        }
        else
            sender.sendMessage("Dieses Commando kann man nur als Spieler benutzen !");
        return false;
    }


}