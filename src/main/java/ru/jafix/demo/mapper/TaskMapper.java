package ru.jafix.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.jafix.demo.model.Task;
import ru.jafix.demo.model.TaskDto;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "title", source = "name")
    @Mapping(target = "isSuccess", source = "completed")
    @Mapping(target = "additionalField", ignore = true)
    Task fromDto(TaskDto taskDto);

}
