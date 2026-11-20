package ru.jafix.demo.repository;

import org.springframework.stereotype.Repository;
import ru.jafix.demo.model.TaskDto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TaskRepository {

    private List<TaskDto> tasks = new ArrayList<>();

    public TaskDto add(TaskDto task) {
        tasks.add(task);
        return task;
    }

    public List<TaskDto> getAll() {
        return tasks;
    }

    public Optional<TaskDto> getById(UUID id) {
        return tasks.stream()
                .filter(e -> id.equals(e.getId()))
                .findFirst();
    }

    public TaskDto update(TaskDto taskDto) {
        Optional<TaskDto> optionalTask = tasks.stream()
                .filter(e -> taskDto.getId().equals(e.getId()))
                .map(e -> {

                    e.setName(taskDto.getName());
                    e.setCompleted(taskDto.isCompleted());

                    return e;
                })
                .findFirst();

        if (optionalTask.isEmpty()) {
            throw new IllegalArgumentException("Задача на найдена");
        }

        return taskDto;
    }

    public void delete(UUID id) {

        Iterator<TaskDto> iterator = tasks.iterator();

        while (iterator.hasNext()) {
            TaskDto taskDto = iterator.next();

            if (id.equals(taskDto.getId())) {
                iterator.remove();
                return;
            }
        }
    }
}
