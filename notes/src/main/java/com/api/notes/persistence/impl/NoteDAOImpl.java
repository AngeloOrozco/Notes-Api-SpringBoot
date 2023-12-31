package com.api.notes.persistence.impl;

import com.api.notes.entities.Note;
import com.api.notes.persistence.INoteDAO;
import com.api.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Component
public class NoteDAOImpl implements INoteDAO {
    @Autowired
    private NoteRepository noteRepository;
    @Override
    public List<Note> findAll() {
        return (List<Note>) noteRepository.findAll();
    }

    @Override
    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<Note> findArchivedNotes() {
        return noteRepository.findAllArchivedNotes();
    }

    @Override
    public List<Note> findAllActives() {
        return noteRepository.findAllActiveNotes();
    }
}
