package com.eduardafbz.repository;

public interface TaskRepository {
    
    void add(Task task)
    List<Task> get_all();
    Task get_by_id(int id);
    void update(Task task);
    void delete_all(List<Task>)
    void delete_by_id(int id)

}
