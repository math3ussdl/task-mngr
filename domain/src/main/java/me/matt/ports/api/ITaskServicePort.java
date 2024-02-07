package me.matt.ports.api;

import me.matt.data.TaskDto;

import java.util.List;

public interface ITaskServicePort {
    List<TaskDto> getTasks();
    TaskDto getTaskById(Long taskId);

    TaskDto addTask(TaskDto data);
    TaskDto updateTask(TaskDto data);
    void deleteTask(Long taskId);
}
