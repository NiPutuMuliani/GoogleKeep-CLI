package com.googlekeep;

/**
 * Hello world!
 */
import java.sql.Connection;

import com.googlekeep.database.DatabaseConnection;

public class App {
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();

        if (conn != null){
            System.out.println("Database connected");
        }
        System.out.println("GOOGLE KEEP CLI!");
        System.out.println("1. Add Note");
        System.out.println("2. View Notes");
        System.out.println("3. Exit");
    }
}
