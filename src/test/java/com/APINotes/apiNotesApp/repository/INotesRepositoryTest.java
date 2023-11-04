package com.APINotes.apiNotesApp.repository;

import com.APINotes.apiNotesApp.models.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest // clase de prueba para persistencia jpa hacia la base de datos
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class INotesRepositoryTest {
    @Autowired
    INotesRepository iNotesRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {

        Notes note =
                Notes.builder()
                        .title("NotasRapidas")
                        .description("MiNota")
                        .build();
        testEntityManager.persist(note);
    }
        @Test
        public void findLocalByTitleFound(){
            Optional<Notes> note = iNotesRepository.findByTitle("NotasRapidas");
            assertEquals(note.get().getTitle(), "NotasRapidas");
            System.out.println("local.get() ="+ note.get());
        }
        @Test
        public void findLocalByTitleNotFound() {
            Optional<Notes> note = iNotesRepository.findByTitle("NotasLentas");
            assertEquals(note, Optional.empty());
        }
    }
