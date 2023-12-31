package com.api.notes.cotrollers;

import com.api.notes.cotrollers.dto.NoteDTO;
import com.api.notes.entities.Note;
import com.api.notes.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/note")
public class NoteController {
    @Autowired
    private INoteService noteService;

    @GetMapping("find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Note> noteOptional = noteService.findById(id);
        if(noteOptional.isPresent()){
            Note note = noteOptional.get();
            NoteDTO noteDTO = NoteDTO.builder()
                    .id(note.getId())
                    .name(note.getName())
                    .content(note.getContent())
                    .active(true)
                    .category(note.getCategory())
                    .build();
            return ResponseEntity.ok(noteDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<NoteDTO> noteList = noteService.findAll().stream()
                .map(note -> NoteDTO.builder()
                        .id(note.getId())
                        .name(note.getName())
                        .content(note.getContent())
                        .active(note.isActive())
                        .category(note.getCategory()).build()).toList();
        return ResponseEntity.ok(noteList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody NoteDTO noteDTO) throws URISyntaxException {
        if(noteDTO.getName().isBlank() || noteDTO.getCategory() == null){
            return ResponseEntity.badRequest().build();
        }

            Note note = Note.builder()
                .name(noteDTO.getName())
                .content(noteDTO.getContent())
                .active(noteDTO.isActive())
                .category(noteDTO.getCategory())
                .build();
        noteService.save(note);

        return ResponseEntity.created(new URI("/api/note/save")).build();

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody NoteDTO noteDTO){
        Optional<Note> noteOptional = noteService.findById(id);
        if(noteOptional.isPresent()){
            Note note = noteOptional.get();
            note.setName(noteDTO.getName());
            note.setContent(noteDTO.getContent());
            note.setActive(noteDTO.isActive());
            note.setCategory(noteDTO.getCategory());

            noteService.save(note);
            return ResponseEntity.ok("successfully updated");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Optional<Note> noteOptional = noteService.findById(id);
        if(noteOptional.isPresent()) {
            noteService.deleteById(id);
            return ResponseEntity.ok("successfully removed");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/findAllActives")
    public ResponseEntity<?> findAllActives(){
        List<NoteDTO> noteList = noteService.findAllActives().stream()
                .map(note -> NoteDTO.builder()
                        .id(note.getId())
                        .name(note.getName())
                        .content(note.getContent())
                        .active(note.isActive())
                        .category(note.getCategory()).build()).toList();
        return ResponseEntity.ok(noteList);
    }

    @GetMapping("/findArchivedNotes")
    public ResponseEntity<?> findArchivedNotes(){
        List<NoteDTO> noteList = noteService.findArchivedNotes().stream()
                .map(note -> NoteDTO.builder()
                        .id(note.getId())
                        .name(note.getName())
                        .content(note.getContent())
                        .active(note.isActive())
                        .category(note.getCategory()).build()).toList();
        return ResponseEntity.ok(noteList);
    }

    @PostMapping("/archiveNote/{id}")
    public ResponseEntity<?> archiveNote(@PathVariable Long id){
        Optional<Note> noteOptional = noteService.findById(id);
        if(noteOptional.isPresent()) {
            noteService.archiveNote(id);
            return ResponseEntity.ok("archived note");
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/unarchiveNote/{id}")
    public ResponseEntity<?> unarchiveNote(@PathVariable Long id){
        Optional<Note> noteOptional = noteService.findById(id);
        if(noteOptional.isPresent()) {
            noteService.unarchiveNote(id);
            return ResponseEntity.ok("unarchived note");
        }
        return ResponseEntity.badRequest().build();
    }


}
