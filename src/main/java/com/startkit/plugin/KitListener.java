package com.startkit.plugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

public class KitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        giveKit(event.getPlayer());
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        new BukkitRunnable() {
            @Override
            public void run() {
                giveKit(player);
            }
        }.runTaskLater(StartKitPlugin.getInstance(), 1L);
    }

    private void giveKit(Player player) {
        PlayerInventory inv = player.getInventory();

        inv.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
        inv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        inv.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));

        inv.addItem(new ItemStack(Material.STONE_SWORD));
        inv.addItem(new ItemStack(Material.STONE_PICKAXE));
        inv.addItem(new ItemStack(Material.STONE_AXE));
    }
}
