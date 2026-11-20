package ru.jafix.demo.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class TaskDto {

    @NotNull
    private UUID id;

    @NotEmpty
    private String name;

    private boolean completed;

}
