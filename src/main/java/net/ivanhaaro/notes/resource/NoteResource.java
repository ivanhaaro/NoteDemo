package net.ivanhaaro.notes.resource;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.ivanhaaro.notes.model.Note;
import net.ivanhaaro.notes.model.Response;
import net.ivanhaaro.notes.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteResource {
    private final NoteService noteService;

    @GetMapping()
    public ResponseEntity<Response> getNotes() {
        return ResponseEntity.ok(
                Response.builder().
                        timeStamp(LocalDateTime.now()).
                        data(Map.of("notes", noteService.list(30))).
                        message("Notes retrieved").
                        status(HttpStatus.OK).
                        statusCode(HttpStatus.OK.value()).
                        build()
        );
    }

    @PostMapping()
    public ResponseEntity<Response> saveNote(@RequestBody @Valid Note note) {
        return ResponseEntity.ok(
                Response.builder().
                        timeStamp(LocalDateTime.now()).
                        data(Map.of("note", noteService.create(note))).
                        message("Note created").
                        status(HttpStatus.CREATED).
                        statusCode(HttpStatus.CREATED.value()).
                        build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<Response> getNote(@PathVariable("id") int id) {
        return ResponseEntity.ok(
                Response.builder().
                        timeStamp(LocalDateTime.now()).
                        data(Map.of("note", noteService.get(id))).
                        message("Note retrieved").
                        status(HttpStatus.OK).
                        statusCode(HttpStatus.OK.value()).
                        build()
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Response> DeleteNote(@PathVariable("id") int id) {
        return ResponseEntity.ok(
                Response.builder().
                        timeStamp(LocalDateTime.now()).
                        data(Map.of("deleted", noteService.delete(id))).
                        message("Note deleted").
                        status(HttpStatus.OK).
                        statusCode(HttpStatus.OK.value()).
                        build()
        );
    }
}
