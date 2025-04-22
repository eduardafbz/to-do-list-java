package com.eduardafbz.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.eduardafbz.model.Task;
import com.eduardafbz.service.TaskService;

public class TaskController implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> add(@RequestBody Task task) {
        Task tsk = taskService.add(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(tsk); 
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task tsk) {
        tsk = taskService.update(id, tsk);
        return ResponseEntity.ok().body(tsk);
    }

    @GetMapping
    public ResponseEntity<List<Task>> get_all() {
        List<Task> tasks = taskService.get_all();
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Task>> get_by_id(@PathVariable Long id) {
        Optional<Task> tsk = taskService.get_by_id(id);
        return ResponseEntity.ok().body(tsk);
    }

    @DeleteMapping
    public ResponseEntity<List<Void>> delete_all() {
        taskService.delete_all();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete_by_id(@PathVariable Long id) {
        taskService.delete_by_id(id);
        return ResponseEntity.noContent().build();
    }
}
