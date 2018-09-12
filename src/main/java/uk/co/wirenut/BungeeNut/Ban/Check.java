package uk.co.wirenut.BungeeNut.Ban;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.event.PreLoginEvent;
import uk.co.wirenut.BungeeNut.BungeeNut;

public class Check {

    public Check(PreLoginEvent event, PendingConnection player) {

        String mysqlHost = (String) BungeeNut.getInstance().configuration.get("mysql.host");
        String mysqlUser = (String) BungeeNut.getInstance().configuration.get("mysql.username");
        String mysqlPass = (String) BungeeNut.getInstance().configuration.get("mysql.password");
        String mysqlDB = (String) BungeeNut.getInstance().configuration.get("mysql.database");

        event.setCancelled(true);
        event.setCancelReason(new TextComponent("You have been banned"));
    }



}
