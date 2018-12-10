package com.demo.springbootcrud.task.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.demo.springbootcrud.user.models.User;

/**
 * @author webwerks
 *This entity represents Task
 */
@Entity
public class Task {

	@Id
	@GeneratedValue(generator = "taskIdGen", strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	private String body;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy="task", fetch=FetchType.EAGER)
	private List<TaskHistory> history = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TaskHistory> getHistory() {
		return history;
	}

	public void setHistory(List<TaskHistory> history) {
		this.history = history;
	}

}
