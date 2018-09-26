package uk.co.wirenut.BungeeNut.events;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PostLoginEvent;
import uk.co.wirenut.BungeeNut.SQL.db;

import java.util.ArrayList;

public class discordCheck {


        public discordCheck(PostLoginEvent event, String player) {

                String sql = "SELECT * FROM players WHERE uuid = '" + player + "' AND active = 1;";

                ArrayList result = new db().query(sql);



                if(!result.isEmpty()) {
                    event.getPlayer().disconnect(new TextComponent("Please Join Our Discord! https://discord.wirenut.tk"));
                }


        }

}
