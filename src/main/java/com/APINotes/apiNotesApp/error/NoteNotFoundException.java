package com.APINotes.apiNotesApp.error;

public class NoteNotFoundException extends Exception{
    public NoteNotFoundException(String message) {
        super(message);
    }
}
