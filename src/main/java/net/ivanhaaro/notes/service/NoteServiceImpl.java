package net.ivanhaaro.notes.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.ivanhaaro.notes.model.Note;
import net.ivanhaaro.notes.repo.NoteRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NoteServiceImpl implements NoteService {

    private final NoteRepo noteRepo;

    public Note create(Note note) {
        log.info("Writing a new note {}", note.getTitle());
        return noteRepo.save(note);
    }

    public Collection<Note> list(int limit) {
        log.info("Fetching all notes");
        return noteRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    public Note update(Note note) {
        log.info("Updating note {}", note.getTitle());
        return noteRepo.save(note);
    }

    public Note get(int id) {
        log.info("Fetching note by ID: {}", id);
        return noteRepo.findById(id).get();
    }

    public boolean delete(int id) {
        log.info("Deleting note by ID: {}", id);
        noteRepo.deleteById(id);
        return true;
    }
}
