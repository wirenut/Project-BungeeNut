package uk.co.wirenut.BungeeNut.configuration;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import uk.co.wirenut.BungeeNut.BungeeNut;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class players {

    private File file;
    private Configuration playersCache;

    public players() {

    }

    public Configuration load() {
        try {
            if (!BungeeNut.getInstance().getDataFolder().exists()) {
                BungeeNut.getInstance().getDataFolder().mkdir();
            }

            file = new File(BungeeNut.getInstance().getDataFolder(), "players.yml");

            if (!file.exists()) {
                try (InputStream in = BungeeNut.getInstance().getResourceAsStream("players.yml")) {
                    Files.copy(in, file.toPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            playersCache = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return playersCache;
    }
}
