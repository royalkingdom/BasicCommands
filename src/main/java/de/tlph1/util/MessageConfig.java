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
            cfg.set("Settings.PlayerOffline", "Der Spieler &e%player% &fist nicht online");
            cfg.set("Settings.Prefix", "&2RoyalKingdom &5> &r");
            cfg.set("Settings.PluginStart","&2&lDas Plugin ist Gestartet!");
            cfg.set("Settings.NoPerm", "&4Dazu hast du keine Rechte!");
        }
        if(!cfg.contains("BasicCommands.DayNight")){
            cfg.set("BasicCommands.DayNight.Day", "&2Es ist nun Tag!");
            cfg.set("BasicCommands.DayNight.DayCMD", "&2Benutze /day!");
            cfg.set("BasicCommands.DayNight.Night", "&2Es ist nun Nacht!");
            cfg.set("BasicCommands.DayNight.NightCMD", "&2Benutze /night!");
        }
        if(!cfg.contains("BasicCommands.Fly")){
            cfg.set("BasicCommands.Fly.Fly", "&aDu kannst nun fliegen");
            cfg.set("BasicCommands.Fly.FlyOther", "&2Du hast &e%player% &fin den Flugmodus gesetzt");
            cfg.set("BasicCommands.Fly.NoFly", "&cDu kannst nun nicht mehr fliegen");
            cfg.set("BasicCommands.Fly.NoFlyOther", "&2Du hast &e%player% &fden Flugmodus entfernt");
            cfg.set("BasicCommands.Fly.FlyCMD", "Bitte benutze /fly");
        }
        if(!cfg.contains("BasicCommands.Vanish")){
            cfg.set("BasicCommands.Vanish.Unsichtbar", "&aDu bist nun unsichtbar");
            cfg.set("BasicCommands.Vanish.Schtbar", "&aDu bist nun sichtbar");
        }
        if(!cfg.contains("BasicCommands.SunRain")){
            cfg.set("BasicCommands.SunRain.Sun","&eDie Sonne erscheint !");
            cfg.set("BasicCommands.SunRain.SunCMD","&cBitte benutze /sun");
            cfg.set("BasicCommands.SunRain.Rain","&cEin Gewitter zieht auf !");
            cfg.set("BasicCommands.SunRain.RainCMD","&cBitte benutze /rain");
        }
        if(!cfg.contains("BasicCommands.Heal")){
            cfg.set("BasicCommands.Heal.Heal", "&aDu wurdest geheilt!");
            cfg.set("BasicCommands.Heal.HealOther", "&aDu hast den Spieler §6%player% &ageheilt.");
            cfg.set("BasicCommands.Heal.HealCMD", "&cBitte Benutze §6/heal oder /heal<SPIELER>");
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
