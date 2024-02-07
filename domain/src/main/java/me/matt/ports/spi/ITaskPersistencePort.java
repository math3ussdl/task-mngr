package me.matt.ports.spi;

import me.matt.data.TaskDto;

import java.util.List;

public interface ITaskPersistencePort {
    List<TaskDto> getTasks();
    TaskDto getTaskById(Long taskId);

    TaskDto addTask(TaskDto data);
    TaskDto updateTask(TaskDto data);
    void deleteTask(Long taskId);
}
