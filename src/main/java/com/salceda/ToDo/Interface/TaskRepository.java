package com.salceda.ToDo.Interface;

import com.salceda.ToDo.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(long userId);
    List<Task> findByTitleContainingIgnoreCase(String title);
    List<Task> findByCreatedOn(Date date);
}
