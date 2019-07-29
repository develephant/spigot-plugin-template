package com.develephant.exampleplugin;

import com.develephant.exampleplugin.commands.ExampleCommand;
import com.develephant.exampleplugin.events.PlayerJoin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ExamplePlugin extends JavaPlugin {
    private static JavaPlugin plugin;
    private static String dataFolder;

    @Override
    public void onEnable() {
        plugin = this;

        /* Data directory and config */
        File dir = this.getDataFolder();
        if (!dir.isDirectory()) {
            boolean res = dir.mkdir();
        }

        // Store data folder path
        dataFolder = this.getDataFolder().getPath();

        // Set default config
        this.saveDefaultConfig();

        /* Register events */
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(), this);

        /* Register commands */
        this.getCommand("example").setExecutor(new ExampleCommand());

    }

    @Override
    public void onDisable() {
        this.getLogger().info("See you next time. :)");
    }

    /* Static Methods */
    public static JavaPlugin getPlugin() { return plugin; }

    public static String getDataDirectory() { return dataFolder; }

    public static FileConfiguration getConfiguration() {
        return plugin.getConfig();
    }

    //Messaging
    public static void broadcast(String msg) {
        plugin.getServer().broadcastMessage(msg);
    }

    public static void log(String msg) {
        plugin.getLogger().info(msg);
    }
}
