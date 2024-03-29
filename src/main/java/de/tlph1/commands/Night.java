package de.tlph1.commands;

import de.tlph1.util.ConfigWerte;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Night implements CommandExecutor {

    private ConfigWerte cw;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        cw = new ConfigWerte();
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("bc.time")){
                if(args.length == 0) {
                    p.getWorld().setTime(15000);
                    ConfigWerte.playerMessage(p,cw.Prefix + cw.Night);
                }else
                    ConfigWerte.playerMessage(p,cw.Prefix + cw.NightCMD);
            }else
                ConfigWerte.playerMessage(p,cw.Prefix + cw.NoPerm);
        }else
            ConfigWerte.consoleMessage(cw.Prefix + cw.PlayerCommand);
        return false;
    }
}
