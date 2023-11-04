package com.APINotes.apiNotesApp.services;

import com.APINotes.apiNotesApp.models.Notes;
import com.APINotes.apiNotesApp.repository.INotesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class INotesServicesTest {
    @Autowired
    INotesServices iNotesServices;
    @MockBean
    INotesRepository iNotesRepository;

    @BeforeEach
    void setUp() {
        Notes notes = Notes.builder()
                .id(1L)
                .title("Tetera")
                .description("JAJAJAJA")
                .build();
        Mockito.when(iNotesRepository.findByTitle("Tetera")).thenReturn(Optional.of(notes));
    }
    @Test
    @DisplayName("Prueba de obtencion de informacion de un local enviando un nombre valido")
    public void findByTitleShouldFound() {
        String noteTitle = "Tetera";
        Notes notes = iNotesServices.findByTitle(noteTitle).get();
        assertEquals(noteTitle, notes.getTitle());
        System.out.println("Notes = " + notes);
    }
}