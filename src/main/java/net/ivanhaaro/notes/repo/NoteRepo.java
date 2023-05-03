package net.ivanhaaro.notes.repo;

import net.ivanhaaro.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note, Integer> {
    Note findByTitle(String title);
}
