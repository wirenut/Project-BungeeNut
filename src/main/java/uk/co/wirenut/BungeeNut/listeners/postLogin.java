package uk.co.wirenut.BungeeNut.listeners;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;
import uk.co.wirenut.BungeeNut.BungeeNut;
import uk.co.wirenut.BungeeNut.events.banCheck;
import uk.co.wirenut.BungeeNut.events.discordCheck;

import java.io.File;
import java.io.IOException;

public class postLogin implements Listener {

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {

        String playerUUID = event.getPlayer().getUniqueId().toString();

        String player = event.getPlayer().getName();

        //new banCheck(event, playerUUID);
        //new discordCheck(event, playerUUID);

        try {

            BungeeNut.getInstance().playersCache.set(playerUUID, player.toLowerCase());

            ConfigurationProvider.getProvider(YamlConfiguration.class).save(BungeeNut.getInstance().playersCache, new File(BungeeNut.getInstance().getDataFolder(), "players.yml"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        ProxyServer.getInstance().createTitle()
                .title(new ComponentBuilder("Welcome " + player)
                        .color(ChatColor.GOLD).create())
                .subTitle(new ComponentBuilder("Line 1")
                        .color(ChatColor.YELLOW).create())
                .fadeIn(20)
                .stay(100)
                .fadeOut(20)
                .send(event.getPlayer());


    }

}
