package com.java.unittests;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoUtility {

    private static Properties dbProperties;

    static {
        dbProperties = new Properties();
    }

    public static void loadDbConfiguration(String path)
            throws IOException {
        FileReader reader = new FileReader(path);
        dbProperties.load(reader);
    }

    public static void loadDriver() throws ClassNotFoundException, Exception {
        if (dbProperties != null) {
            String driver = dbProperties.getProperty("driver");
            if (driver != null && driver != "")
                Class.forName(dbProperties.getProperty("driver"));
            else
                throw new Exception("Driver Name is either null or empty");
        } else
            throw new Exception("db configuration not loaded from properties file");
    }

    public static Connection createConnection() throws SQLException, Exception {
        if (dbProperties != null)
            return DriverManager.getConnection(
                    dbProperties.getProperty("url"),
                    dbProperties.getProperty("username"),
                    dbProperties.getProperty("password"));
        else
            throw new Exception("db configuration not loaded from properties file");
    }

    public static void closeConnection(Connection connection) throws SQLException, Exception {
        if (connection != null)
            connection.close();
        else
            throw new Exception("connection was not initialized at all");
    }
}
