package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public String getAllTasks(Model model){
        model.addAttribute("tasks",taskService.getAllTasks());
        return "tasks";
    }
    @GetMapping("/{taskId}")
    public String getTaskDetails(@PathVariable Long taskId, Model model){
        Task task = taskService.getTaskById(taskId);
        model.addAttribute("task",task);
        return "task-details";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("task", new Task());
        return "create-task";
    }
    @PostMapping("/create")
    public String createTask(@ModelAttribute Task task){
        taskService.addTask(task);
        return "redirect:/tasks";
    }
    @GetMapping("/{taskId}/edit")
    public String showEditForm(@PathVariable Long taskId, Model model){
        Task task = taskService.getTaskById(taskId);
        model.addAttribute("task",task);
        return "edit-task";
    }
    @PostMapping("/{taskId}/edit")
    public String updateTask(@PathVariable Long taskId, @ModelAttribute Task updatedTask){
        Task existingTask = taskService.getTaskById(taskId);
        existingTask.setName(updatedTask.getName());
        existingTask.setNotes(updatedTask.getNotes());
        taskService.updateTask(existingTask);
        return "redirect:/tasks";
    }
    @GetMapping("/{taskId}/delete")
    public String showDeleteConfirmation(@PathVariable Long taskId, Model model){
        Task task = taskService.getTaskById(taskId);
        model.addAttribute("task",task);
        return "delete-confirmation";
    }
    @PostMapping("/{taskId}/delete")
    public String deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return "redirect:/tasks";
    }
}