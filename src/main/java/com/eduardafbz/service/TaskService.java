package com.eduardafbz.service;

import com.eduardafbz.repository.TaskRepository;

public class TaskService {
    
    public final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task add(Task t) {
        return taskRepository.add(t);
    }

    public List<Task> get_all() {
        return taskRepository.get_all();
    }

    public Task get_by_id(int id) {
        return taskRepository.get_by_id(id);
    }

    public Task update(Task t) {
        return taskRepository.update(t);
    }

    public List<Task> delete_all() {
        return taskRepository.delete_all();
    }

    public Task delete_by_id(int id) {
        return taskRepository.delete_by_id(id);
    }

}
