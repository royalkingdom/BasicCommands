package de.tlph1.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player) sender;
    if (sender instanceof Player){
        if(sender.hasPermission("bc.fly")){
            if(args.length == 0){
                if(p.getAllowFlight() == false){
                    p.setAllowFlight(true);
                    p.sendMessage("§aDu kannst nun fliegen");
                }else if(p.getAllowFlight() == true) {
                    p.setAllowFlight(false);
                    p.sendMessage("§cDu kannst nun nicht mehr fliegen");
                }
            }else if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null) {
                    if (target != sender) {
                        if (target.getAllowFlight() == false) {
                            target.setAllowFlight(true);
                            target.sendMessage("§aDu kannst nun fliegen");
                            p.sendMessage("Du hast §e" + target.getName() + " §fin den Flugmodus gesetzt");
                        } else if (target.getAllowFlight() == true){
                            target.setAllowFlight(false);
                        target.sendMessage("§cDu kannst nun nicht mehr fliegen");
                        p.sendMessage("Du hast §e" + target.getName() + " §fden Flugmodus entfernt");
                    }
                    }else p.sendMessage("Bitte benutze /fly");
                    } else p.sendMessage("Der Spieler §e " + target.getName() + " §fist nicht online");
            }

        }else
            p.sendMessage("§cDu hast nicht die benötigten Rechte für diesen Befehl");
    }else
        Bukkit.getConsoleSender().sendMessage("§cDiesen befehl darf man nur als Spieler ausführen !");


        return false;
    }
}
