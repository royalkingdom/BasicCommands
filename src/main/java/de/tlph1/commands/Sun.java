package de.tlph1.commands;

import de.tlph1.util.ConfigWerte;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sun implements CommandExecutor {

    private ConfigWerte cw;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        cw = new ConfigWerte();
        Player p = (Player) sender;
        if(sender instanceof Player){
            if(p.hasPermission("bc.weather")){
                if(args.length == 0){
                    p.getLocation().getWorld().setStorm(false);
                    p.getLocation().getWorld().setThundering(false);
                    ConfigWerte.playerMessage(p,cw.Prefix + cw.Sun);
                }else
                    ConfigWerte.playerMessage(p,cw.Prefix + cw.SunCMD);
            }else
                ConfigWerte.playerMessage(p, cw.Prefix + cw.NoPerm);
        }else
            ConfigWerte.consoleMessage(cw.Prefix + cw.PlayerCommand);
        return false;
    }
}