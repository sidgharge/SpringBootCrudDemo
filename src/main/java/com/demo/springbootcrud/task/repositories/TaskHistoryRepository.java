package com.demo.springbootcrud.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springbootcrud.task.models.TaskHistory;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Long> {

}
