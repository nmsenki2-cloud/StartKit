package com.startkit.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class StartKitPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new KitListener(this), this);
        getLogger().info("StartKit plugin bekapcsolva!");
    }

    @Override
    public void onDisable() {
        getLogger().info("StartKit plugin kikapcsolva!");
    }
}
