package com.eduardafbz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardafbz.model.Task;
import com.eduardafbz.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    public final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task add(Task t) {
        return taskRepository.save(t);
    }

    public Task update(Long id, Task tsk) {
        Task task = taskRepository.getOne(id);
        updateData(task, tsk);
        return taskRepository.save(task);
    }

    private void updateData(Task task, Task tsk) {
        task.setTitle(tsk.getTitle());
        task.setDescription(tsk.getDescription());
        task.setCompleted(tsk.getCompleted());
    }

    public List<Task> get_all() {
        return taskRepository.findAll();
    }

    public Optional<Task> get_by_id(Long id) {
        return taskRepository.findById(id);
    }

    public void delete_all() {
        taskRepository.deleteAll();
    }

    public void delete_by_id(Long id) {
        taskRepository.deleteById(id);
    }

}
