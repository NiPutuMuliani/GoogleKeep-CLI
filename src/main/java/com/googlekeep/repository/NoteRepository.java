package com.googlekeep.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.googlekeep.database.DatabaseConnection;
import com.googlekeep.model.Note;

public class NoteRepository {

    public void save(Note note){
        String sql = "INSERT INTO notes(title, content) VALUES(?, ?)";

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
            pstmt.setString(1, note.getTitle());
            pstmt.setString(2, note.getContent());

            pstmt.executeUpdate();

            System.out.println("Note saved successfully.");   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Note> findAll(){
        List<Note> notes = new ArrayList<>();
        
        String sql = "SELECT * FROM notes";
        
         try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                Note note = new Note();

                note.setId(rs.getInt("id"));
                note.setTitle(rs.getString("title"));
                note.setContent(rs.getString("content"));

                notes.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notes;
    }
        

    public List<Note> searchByTitle(String keyword){
        List<Note> notes = new ArrayList<>();

        String sql = "SELECT * FROM notes WHERE title LIKE ?";

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, "%" + keyword + "%");
            
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Note note = new Note();

                note.setId(rs.getInt("id"));
                note.setTitle(rs.getString("title"));
                note.setContent(rs.getString("content"));
                notes.add(note);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return notes;
    }

    public void update(Note note){
        String sql ="UPDATE notes SET title =?, content = ? WHERE id = ?";
        
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, note.getTitle());
            pstmt.setString(2, note.getContent());
            pstmt.setInt(3, note.getId());
            
            int rows = pstmt.executeUpdate();

            if (rows > 0){
                System.out.println("Note updated successfully.");
            } else {
                System.out.println("Note not found.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

        
    

       
