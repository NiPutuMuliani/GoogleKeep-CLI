package com.googlekeep.service;

import java.util.List;

import com.googlekeep.model.Note;
import com.googlekeep.repository.NoteRepository;

public class NoteService {

    private final NoteRepository repository;

    public NoteService(){
        this.repository = new NoteRepository();
    }

    public NoteService(NoteRepository repository){
        this.repository = repository;
    }

    public void addNote(String title, String content){
        Note note = new Note(title, content);
        repository.save(note);
    }

    public void updateNote(int id, String title, String content){
        Note note = new Note(title, content);
        note.setId(id);

        repository.update(note);
    }

    public void deleteNote(int id){
        repository.delete(id);
    }

    public List<Note> getAllNotes(){
        return repository.findAll();
    }

    public List<Note> searchNotes(String keyword){
        return repository.searchByTitle(keyword);
    }
}

