package uk.co.wirenut.BungeeNut.ban;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PostLoginEvent;
import uk.co.wirenut.BungeeNut.BungeeNut;
import uk.co.wirenut.BungeeNut.SQL.db;

import java.util.ArrayList;
import java.util.HashMap;


public class Check {



    public Check(PostLoginEvent event, String player) {

        String sql = "SELECT * FROM bans WHERE uuid = '" + player + "';";

        ArrayList result = new db().query(sql);



        if(!result.isEmpty()) {
            HashMap firstResult = (HashMap) result.get(1);
            event.getPlayer().disconnect(new TextComponent("You have been banned! Reason: " + firstResult.get("reason")));
        }


    }



}
