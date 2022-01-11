package eu.nawiasdev.ThunderEntrance.util;

import org.bukkit.Bukkit;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

import static eu.nawiasdev.ThunderEntrance.util.FileTreeInitializer.PLUGIN_DIR;

public final class ConfigUtil {
    public static final String PLAYERS_FILE = PLUGIN_DIR +"/players.txt";
    private static final ArrayList<String> thunderPlayers = new ArrayList<String>();
    public static ArrayList<String> getThunderPlayers() {
        if(thunderPlayers.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader(PLAYERS_FILE))) {
                while (br.ready()) {
                    String line = br.readLine();
                    if(!("".equals(line)))
                        thunderPlayers.add(br.readLine());
                }
            } catch (IOException e) {
                Bukkit.getServer().getLogger().info("Could not load ThunderPlayers from file.");
                thunderPlayers.add("CZLOWIEK_PIERNIK");
            }
        }
        return thunderPlayers;
    }
}
