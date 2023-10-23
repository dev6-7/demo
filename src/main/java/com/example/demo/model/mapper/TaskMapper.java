package com.example.demo.model.mapper;

import com.example.demo.model.dto.TaskDTO;
import com.example.demo.model.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "text", target = "text")
    TaskDTO createTask(TaskEntity taskEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "text", target = "text")
    TaskEntity toEntity(TaskDTO taskEntity);
}
