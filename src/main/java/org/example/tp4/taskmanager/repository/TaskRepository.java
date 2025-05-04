package org.example.tp4.taskmanager.repository;


import org.example.tp4.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
