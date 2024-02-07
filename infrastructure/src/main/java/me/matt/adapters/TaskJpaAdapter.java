package me.matt.adapters;

import me.matt.data.TaskDto;
import me.matt.entities.Task;
import me.matt.mappers.TaskMapper;
import me.matt.ports.spi.ITaskPersistencePort;
import me.matt.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskJpaAdapter implements ITaskPersistencePort {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskDto> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return TaskMapper.INSTANCE.taskListToTaskDtoList(tasks);
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        return task.map(TaskMapper.INSTANCE::taskToTaskDto).orElse(null);
    }

    @Override
    public TaskDto addTask(TaskDto data) {
        Task task = TaskMapper.INSTANCE.taskDtoToTask(data);
        Task taskSaved = taskRepository.save(task);
        return TaskMapper.INSTANCE.taskToTaskDto(taskSaved);
    }

    @Override
    public TaskDto updateTask(TaskDto data) {
        return addTask(data);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
