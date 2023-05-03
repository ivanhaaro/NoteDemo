package net.ivanhaaro.notes.service;

import net.ivanhaaro.notes.model.Note;

import java.util.Collection;

public interface NoteService {
    Note create(Note note);
    Collection<Note> list(int limit);
    Note update(Note note);
    Note get(int id);
    boolean delete(int id);
}
