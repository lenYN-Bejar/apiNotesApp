package com.APINotes.apiNotesApp.controllers;

import com.APINotes.apiNotesApp.models.Notes;
import com.APINotes.apiNotesApp.services.NotesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class Controllers {
    @Autowired
    NotesServices notesServices;
    @GetMapping()
    public List<Notes> getNotes() {
        return notesServices.getNotes();
    }
    @PostMapping()
    public Notes postNotes(@RequestBody Notes note) {
        return notesServices.createNote(note);
    }
    @PutMapping("/{id}")
    public Notes updateNotes(@RequestBody Notes newNote, @PathVariable Long id) {
        return notesServices.edidNote(newNote, id);
    }
    @DeleteMapping("/{id}")
    public Notes deleteNote(@PathVariable Long id){
        return notesServices.deleteNote(id);
    }

}
