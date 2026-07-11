package com.googlekeep.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializeDatabase() {
        String sql = """
            CREATE TABLE IF NOT EXISTS notes (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                content TEXT NOT NULL,
                created_at TEXT,
                updated_at TETXT
                );
                """;
        try (
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement()
        ) {
            stmt.execute(sql);
            System.out.println("Table notes is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
