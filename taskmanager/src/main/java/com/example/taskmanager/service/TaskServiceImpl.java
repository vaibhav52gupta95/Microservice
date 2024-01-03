package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.getTaskById(id);
    }

    @Override
    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.updateTask(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }
}
