package com.example.demo.service;

import com.example.demo.model.dto.TaskDTO;
import com.example.demo.model.entity.TaskEntity;
import com.example.demo.model.mapper.TaskMapper;
import com.example.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskDTO getTask(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElse(null);
        return taskMapper.createTask(taskEntity);
    }

    public List<TaskDTO> getAll() {
        List<TaskDTO> tasks = taskRepository.findAll()
                .stream()
                .map(taskMapper::createTask)
                .toList();
        return tasks;
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        TaskEntity task = taskMapper.toEntity(taskDTO);
        taskRepository.save(task);
        taskDTO.setId(task.getId());

        log.info("New task created {}", task.getId());
        return taskDTO;
    }
}
