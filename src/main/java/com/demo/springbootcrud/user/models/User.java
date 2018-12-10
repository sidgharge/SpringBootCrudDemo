package com.demo.springbootcrud.user.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.demo.springbootcrud.task.models.Task;

/**
 * @author webwerks
 *
 *This entity represents User
 */
@Entity
public class User {

	@Id
	@GeneratedValue(generator = "userIdGen", strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String email;

	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Task> tasks = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
