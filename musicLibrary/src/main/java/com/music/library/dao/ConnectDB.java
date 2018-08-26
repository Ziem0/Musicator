package com.music.library.dao;

import org.flywaydb.core.Flyway;
import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    private static Connection connection = null;
    private static final String DB_URL = "jdbc:sqlite:musicLibrary/src/main/resources/musicator.db";

    private ConnectDB() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (ConnectDB.class) {
                if (connection == null) {
                    createConnection();
                }
            }
        }
        return connection;
    }

    private static void createConnection() {
        try {
            DriverManager.registerDriver(new JDBC());
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getMigration() {
        Flyway fw = new Flyway();
        fw.setDataSource(DB_URL, "ziemo", "123");
//        fw.clean();
        fw.migrate();
    }


    public static void main(String[] args) {
        ConnectDB.getConnection();
//        getMigration();
        close();
    }
}
