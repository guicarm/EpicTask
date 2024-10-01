package br.com.fiap.todolist.task;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Task {

    @Id
    UUID id = UUID.randomUUID();

    @NotBlank
    String title;

    @Size(min = 10, message = "descrição deve ter pelo menos 10 caracteres")
    String description;

    @Min(1)
    int score;

    @Min(0) @Max(100)
    int status;
}
