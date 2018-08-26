package com.music.library.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public abstract class AbstractDao {

    void displayAll(ResultSet result) throws SQLException {
        ResultSetMetaData meta = result.getMetaData();
        int columnCounter = meta.getColumnCount();
        for (int i = 1; i <= columnCounter; i++) {
            System.out.printf("%-30s",meta.getColumnLabel(i).toUpperCase());
        }
        System.out.println("\n");

        while (result.next()) {
            for (int i = 1; i <= columnCounter; i++) {
                System.out.printf("%-30s",result.getString(i));
            }
            System.out.println("\n");
        }
    }

    
}
