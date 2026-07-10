package com.googlekeep;

/**
 * Hello world!
 */
git import java.sql.Connection;

import com.googlekeep.database.DatabaseConnection;

public class App {
    public static void main(String[] args) {

        Connection conn = DatabaseConnection.getConnection();
        DatabaseInitializer.initializeDatabase();


        if (conn != null){
            System.out.println("Database connected");
        }
        System.out.println("GOOGLE KEEP CLI!");
        System.out.println("1. Add Note");
        System.out.println("2. View Notes");
        System.out.println("3. Exit");
    }
}
