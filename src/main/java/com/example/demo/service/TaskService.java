package com.example.demo.service;

import com.example.demo.model.entity.Task;
import com.example.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
}
