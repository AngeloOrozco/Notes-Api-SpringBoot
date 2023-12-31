package com.api.notes.repository;

import com.api.notes.entities.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    // Consulta para traer todas las notas archivadas (que no están activas)
    @Query("SELECT n FROM Note n WHERE n.active = false")
    List<Note> findAllArchivedNotes();

    // Consulta para traer todas las notas activas (que no están archivadas)
    @Query("SELECT n FROM Note n WHERE n.active = true")
    List<Note> findAllActiveNotes();
}
