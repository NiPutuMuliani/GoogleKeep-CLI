package com.googlekeep.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:googlekeep.db";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL);
        } catch (SQLException e){
            System.out.println("Failed to connect to database.");
            e.printStackTrace();
            return null;
        }
    }
}
