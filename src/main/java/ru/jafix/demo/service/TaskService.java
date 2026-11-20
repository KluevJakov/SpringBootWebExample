package ru.jafix.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jafix.demo.model.TaskDto;
import ru.jafix.demo.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDto createTask(TaskDto task) {
        boolean exists = getByTaskId(task.getId()).isPresent();

        if (exists) {
            throw new IllegalArgumentException("Задача с таким id уже существует");
        }

        return taskRepository.add(task);
    }

    public List<TaskDto> getAllTasks() {
        return taskRepository.getAll();
    }

    public Optional<TaskDto> getByTaskId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("id - обязательное поле");
        }

        return taskRepository.getById(id);
    }

    public TaskDto updateTask(UUID id, TaskDto taskDto) {
        if (id == null || taskDto == null) {
            throw new IllegalArgumentException("id и task - обязательные поля");
        }

        taskDto.setId(id);

        return taskRepository.update(taskDto);
    }

    public void deleteTaskById(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("id - обязательное поле");
        }

        taskRepository.delete(id);
    }
}
