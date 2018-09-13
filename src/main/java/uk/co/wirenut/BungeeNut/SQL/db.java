package uk.co.wirenut.BungeeNut.SQL;

import uk.co.wirenut.BungeeNut.BungeeNut;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class db {

    Connection connection = null;

    public db(){

        final String mysqlHost = (String) BungeeNut.getInstance().configuration.get("mysql.host");
        final String mysqlUser = (String) BungeeNut.getInstance().configuration.get("mysql.username");
        final String mysqlPass = (String) BungeeNut.getInstance().configuration.get("mysql.password");
        final String mysqlDB = (String) BungeeNut.getInstance().configuration.get("mysql.database");
        final Integer mysqlPort = (int) BungeeNut.getInstance().configuration.get("mysql.port");

        final String connectionURL = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDB;

        try {
            connection = DriverManager.getConnection(connectionURL, mysqlUser, mysqlPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList query(String sql) {

        ResultSet allResults;


        HashMap<String, String> result = null;

        ArrayList results = new ArrayList();

        try {
            Statement query = connection.createStatement();
            allResults = query.executeQuery(sql);
            ResultSetMetaData resultMetaData = allResults.getMetaData();

            Integer columnsCount = allResults.getMetaData().getColumnCount();

            //results = new HashMap<String, String>();

            while (allResults.next()) {
                result = new HashMap<String, String>();
                for (int i = 1; i < columnsCount + 1; i++) {

                    result.put(resultMetaData.getColumnName(i), allResults.getString(i));
                }
                results.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;

    }

}
