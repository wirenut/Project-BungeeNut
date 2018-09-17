package uk.co.wirenut.BungeeNut;

import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;
import uk.co.wirenut.BungeeNut.ban.Check;

import java.io.File;
import java.io.IOException;

public class Events implements Listener {

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {

        String playerUUID = event.getPlayer().getUniqueId().toString();

        String player = event.getPlayer().getName();

        new Check(event, playerUUID);

        try {

            BungeeNut.getInstance().playersCache.set(player.toLowerCase(), playerUUID);

            ConfigurationProvider.getProvider(YamlConfiguration.class).save(BungeeNut.getInstance().playersCache, new File(BungeeNut.getInstance().getDataFolder(), "players.yml"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
