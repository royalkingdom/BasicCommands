package de.tlph1.main;

import de.tlph1.commands.*;
import de.tlph1.events.Death;
import de.tlph1.events.Join;
import de.tlph1.events.Quit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Basics extends JavaPlugin {


    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("BasicCommands started");
        onCommands();
        registerEvents();
    }

    public void onCommands(){
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
        Bukkit.getPluginManager().registerEvents(new Death(), this);
    }
}
