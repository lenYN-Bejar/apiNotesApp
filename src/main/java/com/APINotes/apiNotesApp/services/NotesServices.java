package com.APINotes.apiNotesApp.services;

import com.APINotes.apiNotesApp.models.Notes;
import com.APINotes.apiNotesApp.repository.INotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NotesServices implements INotesServices {
    @Autowired
    INotesRepository iNotesRepository;

    @Override
    public List<Notes> getNotes() {
        return iNotesRepository.findAll();
    }
    @Override
    public Notes createNote(Notes notes) {
        return iNotesRepository.save(notes);
    }

    @Override
    public Notes edidNote(Notes note, Long id) {
        Notes noteById = iNotesRepository.findById(id).get();
        if (Objects.nonNull(note.getTitle()) && !"".equalsIgnoreCase(note.getTitle())) {
            noteById.setTitle(note.getTitle());
        }
        if (Objects.nonNull(note.getDescription()) && !"".equalsIgnoreCase(note.getDescription())) {
            noteById.setDescription(note.getDescription());
        }
        return iNotesRepository.save(noteById);
    }
    @Override
    public void deleteNote(Long id) {
        iNotesRepository.deleteById(id);
    }

    @Override
    public Optional<Notes> findByTitle(String title) {
        return iNotesRepository.findByTitle(title);
    }
}
