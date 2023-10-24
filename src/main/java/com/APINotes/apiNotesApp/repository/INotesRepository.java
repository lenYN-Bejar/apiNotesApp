package com.APINotes.apiNotesApp.repository;

import com.APINotes.apiNotesApp.models.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotesRepository extends JpaRepository<Notes, Long> {
}
