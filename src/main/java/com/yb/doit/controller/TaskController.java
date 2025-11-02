package com.yb.doit.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.yb.doit.entity.Task;
import com.yb.doit.repository.TaskRepository;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping(value = "")
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        // tasks.sort(Comparator.comparing(Task::getPriority));
        // taskRepository.findAllByOrderByPriorityAsc().forEach(tasks::add);
        // taskRepository.findAll(Sort.by(Sort.Direction.DESC, "priority")).forEach(tasks::add);
        return tasks;
    }

    // @GetMapping(value = "")
    // public List<Task> getAllTasks() {
    //     List<Task> tasks = new ArrayList<>();
    //     taskRepository.findAll().forEach(tasks::add); // Fetch all tasks without DB ordering

    //     tasks.sort((t1, t2) -> {
    //         // Put uncompleted tasks before completed
    //         int completedCompare = Boolean.compare(t1.getIsCompleted(), t2.getIsCompleted());
    //         if (completedCompare != 0) {
    //             return completedCompare;
    //         }
    //         // For tasks with same completion status, sort by priority ascending
    //         return t1.getPriority().compareTo(t2.getPriority());
    //     });

    //     return tasks;
    // }

    @GetMapping(value = "/{taskId}")
    public Optional<Task> getTask(@PathVariable Long taskId) {
        return taskRepository.findById(taskId);
    }

    @PostMapping(value = "")
    public Task createTask(@RequestBody @Valid Task task) {
        return taskRepository.save(task);
    }

    @PutMapping(value = "/{taskId}")
    public Task updateTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PatchMapping(value = "/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskRepository.save(task);
    }
    
    @DeleteMapping(value = "/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskRepository.deleteById(taskId);;
    }
}
