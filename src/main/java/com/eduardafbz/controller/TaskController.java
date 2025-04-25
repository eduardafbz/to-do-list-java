    package com.eduardafbz.controller;

    import java.net.URI;
    import java.util.List;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

    import com.eduardafbz.model.Task;
    import com.eduardafbz.service.TaskService;

    @RestController
    @RequestMapping(value = "/tasks")
    public class TaskController {

        @Autowired
        private TaskService taskService;

        @PostMapping
        public ResponseEntity<Task> add(@RequestBody Task task) {
            task = taskService.add(task);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
            return ResponseEntity.created(uri).body(task);
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
        public ResponseEntity<Task> get_by_id(@PathVariable Long id) {
            Task task = taskService.get_by_id(id);
            return ResponseEntity.ok().body(task);
        }

        @DeleteMapping("/all")
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
