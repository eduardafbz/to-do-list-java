package com.eduardafbz.controller;

import java.io.Serializable;
import java.net.ResponseCache;

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
        tsk = tasksService.update(id, tsk);
        return ResponseEntity.ok().body(tsk);
    }

    @GetMapping
    public ResponseEntity<List<Task>> get_all() {
        List<Task> tasks = taskService.get_all();
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping(value = "/{id}")
    public ResposeEntity<Task> get_by_id(@PathVariable Long id) {
        Task tsk = taskService.get_by_id(id);
        return ResponseEntity.ok().body(tsk);
    }

    @DeleteMapping
    public ResponseEntity<List<Void>> delete_all() {
        taskService.delete_all();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete_by_id(@PathVariable Long id) {
        eventoService.delete_by_id(id);
        return ResponseEntity.noContent().build();
    }
}
