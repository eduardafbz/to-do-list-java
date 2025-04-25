package com.eduardafbz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eduardafbz.model.Task;
import com.eduardafbz.repository.TaskRepository;
import com.eduardafbz.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
        try {
            Task task = taskRepository.getReferenceById(id);
            updateData(task, tsk);
            return taskRepository.save(task);
        }
        catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Task task, Task tsk) {
        task.setTitle(tsk.getTitle());
        task.setDescription(tsk.getDescription());
        task.setCompleted(tsk.getCompleted());
    }

    public List<Task> get_all() {
        return taskRepository.findAll();
    }

    public Task get_by_id(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete_all() {
        taskRepository.deleteAll();
    }

    public void delete_by_id(Long id) {
        try {
            taskRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
