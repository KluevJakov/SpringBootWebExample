package ru.jafix.demo.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class TaskDto {

    @NotNull(message = "Идентификатор является обязательным")
    private UUID id;

    @NotEmpty(message = "Поле name не должно быть пустым")
    private String name;

    private boolean completed;

}
