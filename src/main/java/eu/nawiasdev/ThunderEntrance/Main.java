package eu.nawiasdev.ThunderEntrance;

import eu.nawiasdev.ThunderEntrance.util.ConfigUtil;
import eu.nawiasdev.ThunderEntrance.util.FileTreeInitializer;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    private static final Logger logger = Bukkit.getServer().getLogger();
    @Override
    public void onEnable() {
        FileTreeInitializer.initialize();
        ConfigUtil.getThunderPlayers();

        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvent(Event.Type.PLAYER_JOIN,
                new PlayerJoinListener(),
                Event.Priority.Normal,
                this
        );

        logger.info(this.getDescription().getFullName()+" Enabled");
    }

    @Override
    public void onDisable() {

        logger.info(this.getDescription().getFullName()+" Disabled");
    }
}
