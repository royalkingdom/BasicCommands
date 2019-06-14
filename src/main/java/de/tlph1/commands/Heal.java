package de.tlph1.commands;

import de.tlph1.util.ConfigWerte;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    private ConfigWerte cw;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        cw = new ConfigWerte();
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("bc.heal")) {
                if(args.length == 0) {
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    ConfigWerte.playerMessage(p,cw.Prefix + cw.Heal);
                }
                else if(args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null && p != target) {
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        ConfigWerte.playerMessage(target,cw.Prefix + cw.Heal);
                        ConfigWerte.playerMessage(p,cw.Prefix + cw.HealOther.replace("%player%", args[0]));
                    }else
                        ConfigWerte.playerMessage(p, cw.Prefix + cw.PlayerOffline.replace("%player%",args[0]));
                }else
                    ConfigWerte.playerMessage(p,cw.Prefix + cw.HealCMD);
            }
            else
                ConfigWerte.playerMessage(p,cw.Prefix + cw.NoPerm);
        }
        else
            ConfigWerte.consoleMessage(cw.Prefix + cw.PlayerCommand);
        return false;
    }


}