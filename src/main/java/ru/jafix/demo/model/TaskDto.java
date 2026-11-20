package ru.jafix.demo.model;

import lombok.Data;

import java.util.UUID;

@Data
public class TaskDto {

    private UUID id;
    private String name;
    private boolean completed;

}
