package com.example.taskmanager.repository;
import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class InMemoryTaskRepository implements TaskRepository {
    private final Map<Long, Task> tasks = new HashMap<>();
    private long taskIdCounter = 1;

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public Task getTaskById(Long id) {
        return tasks.get(id);
    }

    @Override
    public void addTask(Task task) {
        long taskId = taskIdCounter++;
        task.setId(taskId);
        tasks.put(taskId, task);
    }

    @Override
    public void updateTask(Task task) {
        if(tasks.containsKey(task.getId())){
            tasks.put(task.getId(), task);
        }
    }

    @Override
    public void deleteTask(Long id) {
        tasks.remove(id);
    }
}