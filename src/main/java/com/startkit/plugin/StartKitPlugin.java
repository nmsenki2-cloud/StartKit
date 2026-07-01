package com.startkit.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class StartKitPlugin extends JavaPlugin {

    private static StartKitPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new KitListener(), this);
        getLogger().info("StartKit plugin betöltve!");
    }

    public static StartKitPlugin getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        getLogger().info("StartKit plugin leállítva.");
    }
}
