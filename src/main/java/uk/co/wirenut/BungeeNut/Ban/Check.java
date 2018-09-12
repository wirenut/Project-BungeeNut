package uk.co.wirenut.BungeeNut.Ban;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PostLoginEvent;
import uk.co.wirenut.BungeeNut.BungeeNut;

import java.sql.*;


public class Check {



    public Check(PostLoginEvent event, String player) {

        final String mysqlHost = (String) BungeeNut.getInstance().configuration.get("mysql.host");
        final String mysqlUser = (String) BungeeNut.getInstance().configuration.get("mysql.username");
        final String mysqlPass = (String) BungeeNut.getInstance().configuration.get("mysql.password");
        final String mysqlDB = (String) BungeeNut.getInstance().configuration.get("mysql.database");
        final Integer mysqlPort = (int) BungeeNut.getInstance().configuration.get("mysql.port");

        final String connectionURL = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDB;

        BungeeNut.getInstance().getLogger().info(connectionURL);
        BungeeNut.getInstance().getLogger().info(mysqlUser);
        BungeeNut.getInstance().getLogger().info(mysqlPass);
        BungeeNut.getInstance().getLogger().info(mysqlDB);
        BungeeNut.getInstance().getLogger().info(mysqlPort.toString());

        Connection connection = null;
        String sql = null;
        ResultSet result = null;


        try {
            connection = DriverManager.getConnection(connectionURL, mysqlUser, mysqlPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement query = connection.createStatement();
            result = query.executeQuery("SELECT * FROM bans WHERE uuid = '" + player + "';");
            if(result.first()){
                event.getPlayer().disconnect(new TextComponent("You have been banned! Reason: " + result.getString("reason")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}
