package uk.co.wirenut.BungeeNut;

import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import uk.co.wirenut.BungeeNut.Ban.Check;

public class Events implements Listener {

    @EventHandler
    public void onPreLogin(final PreLoginEvent event) {

        PendingConnection player = event.getConnection();

        new Check(event, player);
    }

}

