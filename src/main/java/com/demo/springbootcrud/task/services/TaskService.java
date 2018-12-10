package com.demo.springbootcrud.task.services;

import java.util.List;

import com.demo.springbootcrud.exceptions.TaskNotFoundException;
import com.demo.springbootcrud.exceptions.UserNotFoundException;
import com.demo.springbootcrud.task.dtos.TaskCreateDto;
import com.demo.springbootcrud.task.dtos.TaskDetailsDto;
import com.demo.springbootcrud.task.dtos.TaskDto;

/**
 * @author webwerks
 *Service layer used for doing operations on task
 */
public interface TaskService {

	/**
	 * Creates a task and saves it to database
	 * @param taskCreateDto-Dto representing task
	 * @return TaskDto, representation of the created task
	 * @throws UserNotFoundException - thrown when task is added to the user which does not exist
	 */
	TaskDto createTask(TaskCreateDto taskCreateDto) throws UserNotFoundException;

	/**
	 * @param taskDto - updated task
	 * @return - TaskDto, representation of the updated task
	 * @throws TaskNotFoundException - thrown when task does not exist by given id
	 */
	TaskDto updateTask(TaskDto taskDto) throws TaskNotFoundException;

	/**
	 * @return All the tasks
	 */
	List<TaskDto> getAllTasks();

	/**
	 * Returns task with given id
	 * @param id - identifier of the task
	 * @return - TaskDto, representation of the task
	 * @throws TaskNotFoundException - thrown when task does not exist by given id
	 */
	TaskDto getTaskById(Long id) throws TaskNotFoundException;

	/**
	 * Deletes task with given id
	 * @param id - identifier of the task
	 * Deletes task by given Id
	 */
	void deleteTask(Long id);

	/**
	 * Return details of the task with given id
	 * @param id - identifier of the task
	 * @return The task with given id
	 * @throws TaskNotFoundException - thrown when task does not exist by given id
	 */
	TaskDetailsDto getTaskDetailsById(Long id) throws TaskNotFoundException;
}
