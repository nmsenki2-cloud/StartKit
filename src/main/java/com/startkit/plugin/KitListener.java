package com.startkit.plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class KitListener implements Listener {

    private final StartKitPlugin plugin;

    public KitListener(StartKitPlugin plugin) {
        this.plugin = plugin;
    }

    // Csak akkor kap kitet, ha ELŐSZÖR lép fel a szerverre
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {
            giveKit(player);
        }
    }

    // Halál/respawn után mindig kap kitet
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        giveKit(player);
    }

    private void giveKit(Player player) {
        player.getInventory().clear();

        player.getInventory().addItem(
                new ItemStack(Material.STONE_SWORD, 1),
                new ItemStack(Material.STONE_PICKAXE, 1),
                new ItemStack(Material.STONE_AXE, 1),
                new ItemStack(Material.CHAINMAIL_HELMET, 1),
                new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1),
                new ItemStack(Material.CHAINMAIL_LEGGINGS, 1),
                new ItemStack(Material.CHAINMAIL_BOOTS, 1)
    }
}
