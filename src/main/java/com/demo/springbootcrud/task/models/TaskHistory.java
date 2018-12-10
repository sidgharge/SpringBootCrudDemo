package com.demo.springbootcrud.task.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/**
 * @author webwerks
 *This class represents operation history of a task
 */
@Entity
public class TaskHistory {

	@Id
	@GeneratedValue(generator = "taskHistoryIdGen", strategy = GenerationType.AUTO)
	private Long id;

	private String operation;

	@ManyToOne
	@JoinColumn(name = "task_hist_id")
	private Task task;

	private LocalDateTime time = LocalDateTime.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}
