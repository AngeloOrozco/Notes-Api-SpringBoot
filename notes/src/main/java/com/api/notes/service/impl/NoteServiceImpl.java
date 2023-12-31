package com.api.notes.service.impl;

import com.api.notes.entities.Note;
import com.api.notes.persistence.INoteDAO;
import com.api.notes.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class NoteServiceImpl implements INoteService {
    @Autowired
    private INoteDAO noteDAO;
    @Override
    public List<Note> findAll() {
        return noteDAO.findAll();
    }

    @Override
    public List<Note> findAllActives() {
        return noteDAO.findAllActives();
    }

    @Override
    public Optional<Note> findById(Long id) {
        return noteDAO.findById(id);
    }

    @Override
    public void save(Note note) {
        noteDAO.save(note);
    }

    @Override
    public void deleteById(Long id) {
        noteDAO.deleteById(id);
    }

    @Override
    public List<Note> findArchivedNotes() {

        return noteDAO.findArchivedNotes();
    }

    @Override
    public void archiveNote(Long id) {
        Note note = noteDAO.findById(id).orElse(null);
        if (note != null) {
            note.setActive(false);
            noteDAO.save(note);
        }
    }

    @Override
    public void unarchiveNote(Long id) {
        Note note = noteDAO.findById(id).orElse(null);
        if (note != null) {
            note.setActive(true);
            noteDAO.save(note);
        }
    }
}
