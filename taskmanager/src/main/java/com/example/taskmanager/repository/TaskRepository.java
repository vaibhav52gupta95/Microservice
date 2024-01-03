package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(Long id);
}
