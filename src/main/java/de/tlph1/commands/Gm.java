package de.tlph1.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gm implements CommandExecutor {



    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(p.hasPermission("bc.gm")) {
                if(args[0].equalsIgnoreCase("1")) {
                    if(p.getGameMode() != GameMode.CREATIVE) {
                        p.sendMessage("§aDein Spielmodus wurde auf §6Creative §agesetzt§f.");
                        p.setGameMode(GameMode.CREATIVE);
                    }else
                        p.sendMessage("Du befindest dich bereits im §6Creative§f.");
                }
                if(args[0].equalsIgnoreCase("0")) {
                    if(p.getGameMode() != GameMode.SURVIVAL) {
                        p.sendMessage("§aDein Spielmodus wurde auf §6Survival §agesetzt§f.");
                        p.setGameMode(GameMode.SURVIVAL);
                    }else
                        p.sendMessage("Du befindest dich bereits im §6Survival§f.");
                }
                if(args[0].equalsIgnoreCase("3")) {
                    if(p.getGameMode() != GameMode.SPECTATOR) {
                        p.sendMessage("§aDein Spielmodus wurde auf §6Spectator §agesetzt§f.");
                        p.setGameMode(GameMode.SPECTATOR);
                    }else
                        p.sendMessage("Du befindest dich bereits im §6Spectator§f.");
                }
                if(args[0].equalsIgnoreCase("2")){
                    if(p.getGameMode() != GameMode.ADVENTURE){
                        p.sendMessage("§aDein Spielmodus wurde auf §6Adventure §agesetzt§f.");
                        p.setGameMode(GameMode.ADVENTURE);
                    } else
                        p.sendMessage("Du befindest dich bereits im §6Adventure§f.");
                }
            }else
                p.sendMessage("§cDu hast nicht die benötigten Rechte für diesen Befehl");

        }
        return false;
    }

}
