package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(Long id);
}
