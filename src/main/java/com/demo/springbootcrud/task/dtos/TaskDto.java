package com.demo.springbootcrud.task.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;


/**
 * @author webwerks
 *
 *This dto is used for sending task details to client.
 */
public class TaskDto {

	@JsonView(View.TitleAndId.class)
	private Long id;

	@JsonView(View.TitleAndId.class)
	private String title;

	private String body;

	private LocalDateTime updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
