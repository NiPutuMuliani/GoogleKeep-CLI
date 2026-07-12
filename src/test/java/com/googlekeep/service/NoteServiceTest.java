package com.googlekeep.service;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.googlekeep.repository.NoteRepository;

public class NoteServiceTest {
    @Test
    void testAddNote(){
        NoteRepository repository =
                mock(NoteRepository.class);

        NoteService service =
                new NoteService(repository);

        service.addNote(
                "Belajar Java",
                "Belajar Mockito"
        );

        verify(repository).save(any());
    }

    @Test
    void testGetAllNotes(){
        NoteRepository repository =
                mock(NoteRepository.class);

        NoteService service =
                new NoteService(repository);

        service.getAllNotes();

        verify(repository).findAll();
    }

    @Test
    void testSearchNotes(){
        NoteRepository repository =
                mock(NoteRepository.class);

        NoteService service =
                new NoteService(repository);

        service.searchNotes("Java");

        verify(repository)
                .searchByTitle("Java");
    }

    @Test
    void testUpdateNote(){
        NoteRepository repository =
                mock(NoteRepository.class);

        NoteService service =
                new NoteService(repository);

        service.updateNote(
            1, 
            "Baru", 
            "Content Baru"
        );

        verify(repository).update(any());
    }

    @Test
    void testDeleteNote(){
        NoteRepository repository =
                mock(NoteRepository.class);

        NoteService service =
                new NoteService(repository);

        service.deleteNote(1);
        
        verify(repository).delete(1);
    }
}
