package com.googlekeep;

/**
 * Hello world!
 */
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.googlekeep.database.DatabaseConnection;
import com.googlekeep.database.DatabaseInitializer;
import com.googlekeep.model.Note;
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

        while (true){

        System.out.println("GOOGLE KEEP CLI!");
        System.out.println("1. Add Note");
        System.out.println("2. View Notes");
        System.out.println("3. Search Note");
        System.out.println("4. Exit");
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
                List<Note> notes = service.getAllNotes();

                if (notes.isEmpty()) {
                    System.out.println("No notes found.");
                } else{
                    for (Note note : notes) {
                        System.out.println("-------");
                        System.out.println("ID:" + note.getId());
                        System.out.println("Title:" + note.getTitle());
                        System.out.println("Content:" + note.getContent());
                    }
                }
                break;

            case 3:
                System.out.println("Enter keyword:");
                String keyword = input.nextLine();

                List<Note> result = service.searchNotes(keyword);

                if(result.isEmpty()){
                    System.out.println("No notes found.");
                } else{
                    for (Note note : result){
                        System.out.println("-----");
                        System.out.println("ID :" + note.getId());
                        System.out.println("Title : " + note.getTitle());
                        System.out.println("Content: " + note.getContent());
                    }
                }
                break;
            
            case 4:
                System.out.println("Goodbye!");
                input.close();
                return;

            default:
                System.out.println("Invalid choice!");
                   }
                }
            }
        
}
