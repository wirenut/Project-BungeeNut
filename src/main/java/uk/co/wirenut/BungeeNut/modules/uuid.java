package uk.co.wirenut.BungeeNut.modules;

import uk.co.wirenut.BungeeNut.BungeeNut;

public class uuid {


    public String get(String username) {

        String Uuid = BungeeNut.getInstance().playersCache.getString(username.toLowerCase());


        return Uuid;
    }

}
