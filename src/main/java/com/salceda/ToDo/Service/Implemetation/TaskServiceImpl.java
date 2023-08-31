package com.salceda.ToDo.Service.Implemetation;

import com.salceda.ToDo.Exception.TaskNotFoundException;
import com.salceda.ToDo.Interface.TaskRepository;
import com.salceda.ToDo.Model.Task;
import com.salceda.ToDo.Service.TaskService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(long id) throws TaskNotFoundException {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found."));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(long id, Task updatedTask) throws TaskNotFoundException {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found for updates."));
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTaskByUserId(long userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public Task completeTask(long id) throws TaskNotFoundException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found for completion."))
                .setCompleted(true);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTaskByTile(String title) {
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Task> getTaskByCreatedOn(Date date) {
        return taskRepository.findByCreatedOn(date);
    }
}
