package eu.nawiasdev.ThunderEntrance;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

import java.util.ArrayList;

import static eu.nawiasdev.ThunderEntrance.util.ConfigUtil.getThunderPlayers;

public class PlayerJoinListener extends PlayerListener {
    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        ArrayList<String> thunderPlayers = getThunderPlayers();
        if(thunderPlayers.contains(event.getPlayer().getName())) {
            Location location = event.getPlayer().getLocation();
            location.getWorld().strikeLightningEffect(location);
            event.setJoinMessage(ChatColor.RED + event.getPlayer().getDisplayName() + ChatColor.GOLD + " has arrived");
        }
        super.onPlayerJoin(event);
    }
}
