package com.googlekeep.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}

