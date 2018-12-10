package com.demo.springbootcrud.task.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author webwerks
 * Dto used for testing
 */
public class TaskDetailsDto {

	@JsonUnwrapped
	@JsonView(View.TitleAndId.class)
	private TaskSummary taskSummary;

	private String body;

	private LocalDateTime updatedAt;

	public TaskSummary getTaskSummary() {
		return taskSummary;
	}

	public void setTaskSummary(TaskSummary taskSummary) {
		this.taskSummary = taskSummary;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
