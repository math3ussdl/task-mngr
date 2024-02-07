package me.matt.configuration;

import me.matt.adapters.TaskJpaAdapter;
import me.matt.ports.api.ITaskServicePort;
import me.matt.ports.spi.ITaskPersistencePort;
import me.matt.services.TaskServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

    @Bean
    public ITaskPersistencePort taskPersistence() {
        return new TaskJpaAdapter();
    }

    @Bean
    public ITaskServicePort taskService() {
        return new TaskServiceImpl(taskPersistence());
    }
}
