package ru.jafix.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.jafix.demo.model.TaskDto;
import ru.jafix.demo.service.TaskService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    private TaskDto createTask(@RequestBody TaskDto task) {
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    private List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    private ResponseEntity<?> getTaskById(@PathVariable("id") UUID id) {
        Optional<TaskDto> optionalTask = taskService.getByTaskId(id);

        if (optionalTask.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity
                .ok(optionalTask.get());
    }

    @PutMapping("/tasks/{id}")
    private TaskDto updateTask(@PathVariable("id") UUID id,
                               @RequestBody TaskDto task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/tasks/{id}")
    private void deleteTask(@PathVariable("id") UUID id) {
        taskService.deleteTaskById(id);
    }

}
