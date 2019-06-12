package de.tlph1.main;

import de.tlph1.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Basics extends JavaPlugin {


    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("BasicCommands gestartet");
        onCommands();
    }

    public void onCommands(){
        getCommand("gm").setExecutor(new Gm());
        getCommand("heal").setExecutor(new Heal());
        getCommand("fly").setExecutor(new Fly());
        getCommand("day").setExecutor(new Day());
        getCommand("night").setExecutor(new Night());
        getCommand("vanish").setExecutor(new Vanish());
    }
}
