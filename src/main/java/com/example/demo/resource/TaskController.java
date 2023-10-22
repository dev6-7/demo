package com.example.demo.resource;

import com.example.demo.model.dto.TaskDTO;
import com.example.demo.model.entity.Task;
import com.example.demo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping(produces = "application/json")
    public List<Task> getTask() {
        return List.of(new Task(1L, "asd", "asd"));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskDTO getTaskById(@PathVariable Long id) {
        return taskService.getTask(id);
    }
}


