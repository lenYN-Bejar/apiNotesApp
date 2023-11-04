package com.APINotes.apiNotesApp.controllers;

import com.APINotes.apiNotesApp.models.Notes;
import com.APINotes.apiNotesApp.services.INotesServices;
import com.APINotes.apiNotesApp.services.NotesServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class Controllers {
    @Autowired
    INotesServices iNotesServices;
    @GetMapping()
    public List<Notes> getNotes() {
        return iNotesServices.getNotes();
    }

    @GetMapping("/jo")
    public Optional<Notes> findByTitle(@RequestParam("title") String titulo) {
        return iNotesServices.findByTitle(titulo);
    }
    @PostMapping()
    public Notes postNotes(@Valid @RequestBody Notes note) {
        return iNotesServices.createNote(note);
    }
    @PutMapping("/{id}")
    public Notes updateNotes(@RequestBody Notes newNote, @PathVariable Long id) {
        return iNotesServices.edidNote(newNote, id);
    }
    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id){
        iNotesServices.deleteNote(id);
        return "Succefully delete";
    }

}
