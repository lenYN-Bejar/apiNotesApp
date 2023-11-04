package com.APINotes.apiNotesApp.controllers;

import com.APINotes.apiNotesApp.models.Notes;
import com.APINotes.apiNotesApp.services.INotesServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controllers.class)
class ControllersTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private INotesServices iNotesServices;

    private Notes notes;
    LocalDateTime currentDateTime = LocalDateTime.now();
    Date date = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant()); // Convierte LocalDateTime a Date

    @BeforeEach
    void setUp() {
        notes = Notes.builder()
                .id(1L)
                .title("La La Land")
                .description("Ganadora del Oscar")
                .fecha_creacion(date)
                .build();
    }
    @Test
    public void saveNote() throws Exception {
        Notes postNotes = Notes.builder()
                .title("La La Land")
                .description("Ganadora del Oscar")
                .fecha_creacion(date)
                .build();
        Mockito.when(iNotesServices.createNote(postNotes)).thenReturn(notes);
        System.out.println("Notas => " + notes);
        mockMvc.perform(post("/api/notes").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "   \"title\":\"La La Land\",\n" +
                        "   \"description\":\"Ganadora del Oscar\"\n" +
                        "}"
                )
        ).andExpect(status().isOk());
    }
    @Test
    public void findNoteByName() throws Exception {
        Mockito.when(iNotesServices.findByTitle("La La Land")).thenReturn(Optional.of(notes));
        mockMvc.perform(get("/api/notes/jo?title=La La Land")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(notes.getTitle()));
    }
}