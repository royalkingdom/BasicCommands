package de.tlph1.main;

import de.tlph1.commands.*;
import de.tlph1.util.ConfigWerte;
import de.tlph1.util.Join;
import de.tlph1.util.MessageConfig;
import de.tlph1.util.Quit;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

public class Basics extends JavaPlugin {

    private MessageConfig mc;
    private ConfigWerte cw;

    @Override
    public void onEnable() {
        mc = new MessageConfig();
        mc.setMessages();
        cw = new ConfigWerte();
        ConfigWerte.consoleMessage("    ");
        ConfigWerte.consoleMessage(cw.Prefix + cw.PluginStart);
        ConfigWerte.consoleMessage("    ");
        registerCommands();
        registerEvents();
    }

    public void registerCommands(){
        getCommand("gm").setExecutor(new Gm());
        getCommand("heal").setExecutor(new Heal());
        getCommand("fly").setExecutor(new Fly());
        getCommand("day").setExecutor(new Day());
        getCommand("night").setExecutor(new Night());
        getCommand("vanish").setExecutor(new Vanish());
        getCommand("rain").setExecutor(new Rain());
        getCommand("sun").setExecutor(new Sun());
    }

    public void registerEvents(){
        Bukkit.getPluginManager().registerEvents(new Join(), this);
        Bukkit.getPluginManager().registerEvents(new Quit(), this);
    }
}
