package ru.jafix.demo.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {

    @NotNull(message = "Идентификатор является обязательным")
    private UUID id;

    @NotEmpty(message = "Поле name не должно быть пустым")
    private String name;

    private boolean completed;

}
