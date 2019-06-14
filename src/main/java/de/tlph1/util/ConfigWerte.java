package de.tlph1.util;

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
    public final String PlayerCommand = cfg.getString("Settings.PlayerCommand");
    public final String PlayerOffline = cfg.getString("Settings.PlayerOffline");

    //JoinLeave
    public final String JoinMessage = cfg.getString("BasicCommnds.JoinLeave.Join");
    public final String QuitMessage = cfg.getString("BasicCommnds.JoinLeave.Quit");

    //DayNight
    public final String Day = cfg.getString("BasicCommands.DayNight.Day");
    public final String Night = cfg.getString("BasicCommands.DayNight.Night");
    public final String DayCMD = cfg.getString("BasicCommands.DayNight.DayCMD");
    public final String NightCMD = cfg.getString("BasicCommands.DayNight.NightCMD");

    //Vanish
    public final String Unsichtbar = cfg.getString("BasicCommands.Vanish.Unsichtbar");
    public final String Sichtbar = cfg.getString("BasicCommands.Vanish.sichtbar");

    //Fly
    public final String Fly = cfg.getString("BasicCommands.Fly.Fly");
    public final String NoFly = cfg.getString("BasicCommands.Fly.NoFly");
    public final String FlyOther = cfg.getString("BasicCommands.Fly.FlyOther");
    public final String NoFlyOther = cfg.getString("BasicCommands.Fly.NoFlyOther");
    public final String FlyCMD = cfg.getString("BasicCommands.Fly.FlyCMD");

    //SunRain
    public final String Sun = cfg.getString("BasicCommands.SunRain.Sun");
    public final String SunCMD = cfg.getString("BasicCommands.SunRain.SunCMD");
    public final String Rain = cfg.getString("BasicCommands.SunRain.Rain");
    public final String RainCMD = cfg.getString("BasicCommands.SunRain.RainCMD");

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
