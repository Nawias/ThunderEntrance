package eu.nawiasdev.ThunderEntrance.util;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class FileTreeInitializer {

    public static final String PLUGIN_DIR = "plugins/ThunderEntrance";

    public static void initialize() {
        File playersFile = new File(PLUGIN_DIR +"/players.txt");
        try {
            if(!playersFile.exists()) {
                String initialPlayers = "CZLOWIEK_PIERNIK";
                playersFile.createNewFile();
                Files.write(playersFile.toPath(),initialPlayers.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

