package com.example.demo.service;

import com.example.demo.model.dto.TaskDTO;
import com.example.demo.model.entity.Task;
import com.example.demo.model.mapper.TaskMapper;
import com.example.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskDTO getTask(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        return taskMapper.createTask(task);
    }
}
