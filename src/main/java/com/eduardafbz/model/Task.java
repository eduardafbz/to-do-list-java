package com.eduardafbz.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task() {
    }

    public Task(Long id, String title, String description, boolean completed, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updatedAt;
    }

    public void mark_completed(){
        this.completed = true;
    }

    public void mark_uncompleted() {
        this.completed = false;
    }

    @Override
    public String toString() {
        return String.format(
            "Task (id = %d, title = %s, description = %s, completed = %b, created at = %s, updated at = %s)",
            id, title, description, completed, createdAt, updatedAt);
    }    
}