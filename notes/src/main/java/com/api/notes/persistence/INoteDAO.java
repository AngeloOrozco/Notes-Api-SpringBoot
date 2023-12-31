package com.api.notes.persistence;

import com.api.notes.entities.Note;

import java.util.List;
import java.util.Optional;

public interface INoteDAO {
    List<Note> findAll();
    List<Note> findAllActives();
    Optional<Note> findById(Long id);
    void save(Note note);
    void deleteById(Long id);
    List<Note> findArchivedNotes();
}
