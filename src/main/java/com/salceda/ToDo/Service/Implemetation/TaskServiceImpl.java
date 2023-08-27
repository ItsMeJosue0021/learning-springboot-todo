package com.salceda.ToDo.Service.Implemetation;

import com.salceda.ToDo.Exception.TaskNotFoundException;
import com.salceda.ToDo.Interface.TaskRepository;
import com.salceda.ToDo.Model.Task;
import com.salceda.ToDo.Service.TaskService;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found."));
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        return existingTask;
    }

    @Override
    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }
}
