package uk.co.wirenut.BungeeNut.SQL;

import uk.co.wirenut.BungeeNut.BungeeNut;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class db {

    Connection connection = null;

    public db(){
        final String mysqlHost = (String) BungeeNut.getInstance().config.get("mysql.host");
        final String mysqlUser = (String) BungeeNut.getInstance().config.get("mysql.username");
        final String mysqlPass = (String) BungeeNut.getInstance().config.get("mysql.password");
        final String mysqlDB = (String) BungeeNut.getInstance().config.get("mysql.database");
        final Integer mysqlPort = (int) BungeeNut.getInstance().config.get("mysql.port");

        final String connectionURL = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDB;

        try {
            connection = DriverManager.getConnection(connectionURL, mysqlUser, mysqlPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList query(String sql) {

        ResultSet allResults;


        HashMap<String, String> result;

        ArrayList results = new ArrayList();

        try {
            Statement query = connection.createStatement();
            allResults = query.executeQuery(sql);
            ResultSetMetaData resultMetaData = allResults.getMetaData();

            Integer columnsCount = allResults.getMetaData().getColumnCount();


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

    public void insert(String sql){
        Statement query;
        try {
            query = connection.createStatement();
            query.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
