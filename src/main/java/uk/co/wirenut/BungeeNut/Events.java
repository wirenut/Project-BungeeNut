package uk.co.wirenut.BungeeNut;

import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import uk.co.wirenut.BungeeNut.Ban.Check;

public class Events implements Listener {

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {

        String player = event.getPlayer().getUniqueId().toString();

        new Check(event, player);

    }

}
