package mappers;

import data.TaskDto;
import entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    // mapper methods
    TaskDto taskToTaskDto(Task task);
    List<TaskDto> taskListToTaskDtoList(List<Task> taskList);
    Task taskDtoToTask(TaskDto taskDto);
    List<Task> taskDtoListToTaskList(List<TaskDto> taskDtoList);
}
