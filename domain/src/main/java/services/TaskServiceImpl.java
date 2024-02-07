package services;

import data.TaskDto;
import ports.api.ITaskServicePort;
import ports.spi.ITaskPersistencePort;

import java.util.List;

public class TaskServiceImpl implements ITaskServicePort {
    private final ITaskPersistencePort taskPersistencePort;

    public TaskServiceImpl(ITaskPersistencePort taskPersistencePort) {
        this.taskPersistencePort = taskPersistencePort;
    }

    @Override
    public List<TaskDto> getTasks() {
        return taskPersistencePort.getTasks();
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        return taskPersistencePort.getTaskById(taskId);
    }

    @Override
    public TaskDto addTask(TaskDto data) {
        return taskPersistencePort.addTask(data);
    }

    @Override
    public TaskDto updateTask(TaskDto data) {
        return taskPersistencePort.updateTask(data);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskPersistencePort.deleteTask(taskId);
    }
}
