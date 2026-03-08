package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService service;

    // CREATE
    @PostMapping
    public String createTask(@RequestBody Task task) throws Exception {

        return service.createTask(task);
    }

    // READ
    @GetMapping
    public List<Task> getTasks() throws Exception {

        return service.getAllTasks();
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateTask(@PathVariable String id,
                             @RequestBody Task task) {

        return service.updateTask(id,task);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id) {

        return service.deleteTask(id);
    }
}