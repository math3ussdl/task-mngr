package me.matt.controllers;

import me.matt.data.TaskDto;
import me.matt.ports.api.ITaskServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskServicePort taskServicePort;

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskServicePort.getTasks();
    }

    @GetMapping("{id}")
    public TaskDto getTaskByID(@PathVariable long id) {
        return taskServicePort.getTaskById(id);
    }

    @PostMapping
    public TaskDto addTask(@RequestBody TaskDto taskDto) {
        return taskServicePort.addTask(taskDto);
    }

    @PatchMapping
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return taskServicePort.updateTask(taskDto);
    }

    @DeleteMapping("{id}")
    public void deleteTaskByID(@PathVariable long id) {
        taskServicePort.deleteTask(id);
    }
}
