package com.demo.springbootcrud.task.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author webwerks
 *
 *Dto used as requestbody for create task api.
 */
public class TaskCreateDto {

	@NotEmpty(message = "Title must not be empty or null")
	private String title;

	@NotEmpty(message = "Body must not be empty or null")
	private String body;

	@NotNull
	private Long userId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
