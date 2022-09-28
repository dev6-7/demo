package com.example.demo.model.mapper;

import com.example.demo.model.dto.TaskDTO;
import com.example.demo.model.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TaskMapper {

    @Mapping(target = "id", source = "id")
    TaskDTO creatTask(Task task);
}
