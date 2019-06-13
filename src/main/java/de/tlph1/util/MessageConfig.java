package de.tlph1.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessageConfig {

    private File file = new File("plugins//RoyalMain//Messages.yml");
    private FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public void setMessages(){
        if(!cfg.contains("BasicCommands.JoinLeave")){
            cfg.set("BasicCommnds.JoinLeave.Join", "&e%player% &aist dem Königreich beigetreten");
            cfg.set("BasicCommnds.JoinLeave.Quit", "&e%player% &chat das Königreich verlassen");
        }
        if(!cfg.contains("Settings")){
            cfg.set("Settings.PlayerCommand", "Dieser Befehl darf man nur als Spieler ausführen !");
        }
        if(!cfg.contains("BasicCommands.DayNight")){
            cfg.set("BasicCommands.DayNight.Day", "&2Es ist nun Tag!");
            cfg.set("BasicCommands.DayNight.DayCMD", "&2Benutze /day!");
            cfg.set("BasicCommands.DayNight.Night", "&2Es ist nun Nacht!");
            cfg.set("BasicCommands.DayNight.NightCMD", "&2Benutze /night!");
        }
        if(!cfg.contains("BasicCommands.Fly")){
            cfg.set("BasicCommands.Fly.Fly", "");
            cfg.set("BasicCommands.Fly.FlyOther", "");
            cfg.set("BasicCommands.Fly.NoFly", "");
            cfg.set("BasicCommands.Fly.NoFlyOther", "");
            cfg.set("BasicCommands.Fly.FlyCMD", "");
        }
        if(!cfg.contains("BasicCommands.Vanish")){
            cfg.set("BasicCommands.Vanish.Unsichtbar", "&aDu bist nun unsichtbar");
            cfg.set("BasicCommands.Vanish.Schtbar", "&aDu bist nun sichtbar");
        }
        save();
    }

    private void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
