package com.salceda.ToDo.Service;

import com.salceda.ToDo.Exception.TaskNotFoundException;
import com.salceda.ToDo.Model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task getTaskById(long id) throws TaskNotFoundException;
    List<Task> getAllTasks();
    Task updateTask(long id, Task updatedTask) throws TaskNotFoundException;
    void deleteTask(long id);
}
