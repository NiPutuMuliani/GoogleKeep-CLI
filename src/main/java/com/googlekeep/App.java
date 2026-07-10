package com.googlekeep;

/**
 * Hello world!
 */
import java.sql.Connection;
import java.util.Scanner;

import com.googlekeep.database.DatabaseConnection;
import com.googlekeep.database.DatabaseInitializer;
import com.googlekeep.service.NoteService;


public class App {
    public static void main(String[] args) {

        Connection conn = DatabaseConnection.getConnection();
        DatabaseInitializer.initializeDatabase();


        if (conn != null){
            System.out.println("Database connected");
        }

        Scanner input = new Scanner(System.in);
        NoteService service = new NoteService();

        System.out.println("GOOGLE KEEP CLI!");
        System.out.println("1. Add Note");
        System.out.println("2. View Notes");
        System.out.println("3. Exit");
        System.out.print("Choose: ");

        int choice = input.nextInt();
        input.nextLine(); // membersihkan enter

        switch (choice){
            case 1:
                System.out.print("Title: ");
                String title = input.nextLine();

                System.out.print("Content: ");
                String content = input.nextLine();

                service.addNote(title, content);
                break;

            case 2:
                System.out.println("View Notes belum dibuat.");
                break;

            case 3:
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Invalid choice!");
        }

        input.close();
    }
}
