package uk.co.wirenut.BungeeNut;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import uk.co.wirenut.BungeeNut.Ban.Check;

import java.util.logging.Logger;

public class Events implements Listener {

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {

        String player = event.getPlayer().getUniqueId().toString();

        //BungeeNut.getInstance().getLogger().info(player);
        new Check(event, player);

    }

}
