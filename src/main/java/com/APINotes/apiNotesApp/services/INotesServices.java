package com.APINotes.apiNotesApp.services;

import com.APINotes.apiNotesApp.models.Notes;

import java.util.List;

public interface INotesServices {
    List<Notes> getNotes();
    Notes createNote(Notes notes);
    Notes edidNote(Notes note, Long id);
    void deleteNote(Long id);

}
