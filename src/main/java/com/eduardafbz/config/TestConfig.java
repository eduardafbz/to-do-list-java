package com.eduardafbz.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eduardafbz.model.Task;
import com.eduardafbz.repository.TaskRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    private TaskRepository taskRepository;

    public void run(String... args) throws Exception {
    Task t1 = new Task(null, "Escrever", "Escrever a redação.", false, null, null);
    Task t2 = new Task(null, "Limpeza", "Limpar o quarto.", false, null, null);

    taskRepository.saveAll(Arrays.asList(t1, t2));
    
    }
}
