package com.APINotes.apiNotesApp.repository;

import com.APINotes.apiNotesApp.models.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface INotesRepository extends JpaRepository<Notes, Long> {
    Optional<Notes> findByTitle(String title);
}
