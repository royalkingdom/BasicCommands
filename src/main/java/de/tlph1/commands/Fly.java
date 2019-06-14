package de.tlph1.commands;

import de.tlph1.util.ConfigWerte;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    private ConfigWerte cw;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player) sender;
    cw = new ConfigWerte();
    if (sender instanceof Player){
        if(sender.hasPermission("bc.fly")){
            if(args.length == 0){
                if(p.getAllowFlight() == false){
                    p.setAllowFlight(true);
                    ConfigWerte.playerMessage(p, cw.Prefix + cw.Fly);
                }else if(p.getAllowFlight() == true && !p.getGameMode().equals(GameMode.CREATIVE)) {
                    p.setAllowFlight(false);
                    ConfigWerte.playerMessage(p, cw.Prefix + cw.NoFly);
                }
                }else if(args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        if (target != sender) {
                            if (target.getAllowFlight() == false) {
                                target.setAllowFlight(true);
                                ConfigWerte.playerMessage(target, cw.Prefix + cw.Fly);
                                ConfigWerte.playerMessage(p, cw.Prefix + cw.FlyOther.replace("%player%", target.getDisplayName()));
                            } else if (target.getAllowFlight() == true){
                                target.setAllowFlight(false);
                                ConfigWerte.playerMessage(target, cw.Prefix + cw.NoFly);
                                ConfigWerte.playerMessage(p, cw.Prefix + cw.NoFlyOther.replace("%player%", target.getDisplayName()));
                            }
                        }else
                            ConfigWerte.playerMessage(p,cw.Prefix + cw.FlyCMD);
                    } else
                        ConfigWerte.playerMessage(p, cw.Prefix + cw.PlayerOffline.replace("%player%", args[0]));
                }
            }else
                ConfigWerte.playerMessage(p, cw.Prefix + cw.NoPerm);
        }else
            ConfigWerte.consoleMessage(cw.Prefix + cw.PlayerCommand);
        return false;
    }
}
