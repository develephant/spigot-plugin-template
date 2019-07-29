package com.develephant.exampleplugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();


    }
}
