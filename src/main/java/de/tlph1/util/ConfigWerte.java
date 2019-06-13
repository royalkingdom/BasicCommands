package de.tlph1.util;

import de.tlph1.commands.*;
import de.tlph1.util.Join;
import de.tlph1.util.Quit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ConfigWerte {

    private File file = new File("plugins//RoyalMain//Messages.yml");
    private FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    //Settings
    public final String Prefix = cfg.getString("Settings.Prefix");
    public final String PluginStart = cfg.getString("Settings.PluginStart");
    public final String NoPerm = cfg.getString("Settings.NoPerm");

    public static void playerMessage(Player player, String message){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }

    public static void consoleMessage(String message){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }

    public static void broadcastMessage(String message){
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',message));
    }

}
