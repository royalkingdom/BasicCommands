package de.tlph1.commands;

import de.tlph1.util.ConfigWerte;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rain implements CommandExecutor {

    private ConfigWerte cw;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        cw = new ConfigWerte();
        Player p = (Player) sender;
        if(sender instanceof Player){
            if(p.hasPermission("bc.weather")){
                if(args.length == 0){
                p.getLocation().getWorld().setStorm(true);
                p.getLocation().getWorld().setThundering(true);
                    ConfigWerte.playerMessage(p,cw.Prefix + cw.Rain);
                }else
                    ConfigWerte.playerMessage(p,cw.Prefix + cw.RainCMD);
            }else
                ConfigWerte.playerMessage(p, cw.Prefix + cw.NoPerm);
        }else
            ConfigWerte.consoleMessage(cw.Prefix + cw.PlayerCommand);
        return false;
    }
}
