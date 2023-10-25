package com.example.demo.model.mapper;

import com.example.demo.model.dto.TaskDTO;
import com.example.demo.model.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO createTask(TaskEntity taskEntity);

    TaskEntity toEntity(TaskDTO taskEntity);
}
