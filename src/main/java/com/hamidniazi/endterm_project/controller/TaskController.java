package com.hamidniazi.endterm_project.controller;

import com.hamidniazi.endterm_project.model.Task;
import com.hamidniazi.endterm_project.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // DEMO: This endpoint forces the use of the Builder Pattern
    @PostMapping("/demo")
    public Task createDemoTask() {
        // USING THE BUILDER PATTERN HERE:
        Task demoTask = new Task.Builder()
                .setTitle("Finish Endterm Project")
                .setDescription("Implement all design patterns and REST endpoints")
                .setPriority("HIGH")
                .setDueDate(LocalDateTime.now().plusDays(7))
                .build();

        return taskRepository.save(demoTask);
    }
}