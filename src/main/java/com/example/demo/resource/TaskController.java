package com.example.demo.resource;

import com.example.demo.model.dto.TaskDTO;
import com.example.demo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<TaskDTO> getAll() {
        return taskService.getAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskDTO getTaskById(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskDTO create(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskDTO update(@RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(taskDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}


