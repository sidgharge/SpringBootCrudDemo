package com.demo.springbootcrud.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springbootcrud.task.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
