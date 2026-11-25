package ru.jafix.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import ru.jafix.demo.model.ErrorDto;
import ru.jafix.demo.model.TaskDto;

import java.util.List;
import java.util.UUID;

@Tag(name = "Работа с задачами", description = "Операции для управления задачами")
public interface TaskController {

    @Operation(
            summary = "Создание задачи",
            description = "Создает задачу по предоставленной модели и возвращает при успешном ответе"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Задача успешно создана",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Ошибка при создании задачи",
                            content = @Content(schema = @Schema(implementation = ErrorDto.class))
                    )
            }
    )
    TaskDto createTask(TaskDto task);

    List<TaskDto> getAllTasks();

    ResponseEntity<?> getTaskById(UUID id);

    TaskDto updateTask(UUID id, TaskDto task);

    @Operation(hidden = true)
    void deleteTask(UUID id);

}
