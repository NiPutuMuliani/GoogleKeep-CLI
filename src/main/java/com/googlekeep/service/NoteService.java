package com.googlekeep.service;

import com.googlekeep.model.Note;
import com.googlekeep.repository.NoteRepository;

public class NoteService {

    private final NoteRepository repository = new NoteRepository();

    public void addNote(String title, String content){
        Note note = new Note(title, content);
        repository.save(note);
    }
}
