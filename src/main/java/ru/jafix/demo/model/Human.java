package ru.jafix.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Human {
    private int age;
    private String name;
    private boolean isEmployeed;

    @JsonProperty("isEmployeed")
    public boolean isEmployeed() {
        return isEmployeed;
    }
}
