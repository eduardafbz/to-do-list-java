package com.eduardafbz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardafbz.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
