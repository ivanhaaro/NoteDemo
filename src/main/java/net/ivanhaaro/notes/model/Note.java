package net.ivanhaaro.notes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ivanhaaro.notes.enumeration.Priority;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;
    @Column(unique = true)
    @NotEmpty(message = "The title of a note cannot be empty")
    private String title;
    private String content;
    private Priority priority;
}
