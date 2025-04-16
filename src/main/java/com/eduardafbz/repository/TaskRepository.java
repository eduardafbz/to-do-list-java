package com.eduardafbz.repository;

import java.util.List;

import com.eduardafbz.model.Task;

public interface TaskRepository {
    
    Task add(Task task);
    List<Task> get_all();
    Task get_by_id(int id);
    Task update(Task task);
    void delete_all(List<Task> tasks);
    Task delete_by_id(int id);

}
