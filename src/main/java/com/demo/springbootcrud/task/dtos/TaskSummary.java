package com.demo.springbootcrud.task.dtos;

import com.fasterxml.jackson.annotation.JsonView;


/**
 * @author webwerks
 * Dto for testing purpose
 */
@JsonView(View.DummyView.class)
public class TaskSummary {
	
	private Long id;

	private String title;

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
	
	
}
