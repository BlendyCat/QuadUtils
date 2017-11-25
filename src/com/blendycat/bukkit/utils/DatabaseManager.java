package com.blendycat.bukkit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by EvanMerz on 11/8/17.
 */
public class DatabaseManager {

    /**
     * remember to close after done with database
     *
     * @return database connection
     */

    public static Connection getConnection() {
        String DB_CONN_STRING = "jdbc:mysql://" + Util.getDatabaseHost() + ":3306/" +
                Util.getDatabaseName();
        String USER_NAME = Util.getDatabaseUser();
        String PASSWORD = Util.getDatabasePassword();
        Connection result = null;

        try {
            result = DriverManager.getConnection(DB_CONN_STRING, USER_NAME, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
