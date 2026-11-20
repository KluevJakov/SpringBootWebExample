package ru.jafix.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {

    private String description;
    private int code;

}
