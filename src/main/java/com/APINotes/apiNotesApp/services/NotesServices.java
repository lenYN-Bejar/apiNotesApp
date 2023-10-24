package com.APINotes.apiNotesApp.services;

import com.APINotes.apiNotesApp.models.Notes;
import com.APINotes.apiNotesApp.repository.INotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class NotesServices {
    @Autowired
    INotesRepository iNotesRepository;

    public List<Notes> getNotes() {
        return iNotesRepository.findAll();
    }

    public Notes createNote(Notes notes) {
        return iNotesRepository.save(notes);
    }

    public Notes edidNote(Notes note, Long id) {
        Notes noteById = iNotesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada"));
        if (note.getTitle() != null) {
            noteById.setTitle(note.getTitle());
        }
        if (note.getDescription() != null) {
            noteById.setDescription(note.getDescription());
        }
        iNotesRepository.save(noteById);
        return noteById;
    }

    public Notes deleteNote(Long id) {
        Notes noteById = iNotesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada"));
        iNotesRepository.deleteById(id);
        return noteById;
    }
}
