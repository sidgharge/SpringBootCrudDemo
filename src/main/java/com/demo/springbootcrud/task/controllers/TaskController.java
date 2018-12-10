package com.demo.springbootcrud.task.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootcrud.exceptions.TaskNotFoundException;
import com.demo.springbootcrud.exceptions.UserNotFoundException;
import com.demo.springbootcrud.task.dtos.CustomResponse;
import com.demo.springbootcrud.task.dtos.TaskCreateDto;
import com.demo.springbootcrud.task.dtos.TaskDetailsDto;
import com.demo.springbootcrud.task.dtos.TaskDto;
import com.demo.springbootcrud.task.dtos.View;
import com.demo.springbootcrud.task.services.TaskService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;

/**
 * @author webwerks
 *
 *Controller contains all the apis related to task
 */
@RestController
@RequestMapping("${version}/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskCreateDto taskCreateDto) throws UserNotFoundException {
		TaskDto taskDto = taskService.createTask(taskCreateDto);
		return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Update task", response=TaskDto.class)
	@PutMapping
	public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) throws TaskNotFoundException {
		TaskDto updatedTaskDto = taskService.updateTask(taskDto);
		return new ResponseEntity<>(updatedTaskDto, HttpStatus.OK);
	}
	
	@ApiOperation(value="Get all tasks", responseContainer="List", response=TaskDto.class)
	@GetMapping
	public ResponseEntity<List<TaskDto>> getAllTasks() {
		List<TaskDto> tasks = taskService.getAllTasks();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@ApiOperation(value="Get task by it's id", response=TaskDto.class)
	@GetMapping("/{id}")
	public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) throws TaskNotFoundException {
		TaskDto taskDto = taskService.getTaskById(id);
		return new ResponseEntity<>(taskDto, HttpStatus.OK);
	}
	
	@ApiOperation(value="Delete task by it's id", response=CustomResponse.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<CustomResponse> deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		CustomResponse customResponse = new CustomResponse(1, "Task deleted successfully");
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}
	
	@JsonView(View.TitleAndId.class)
	@GetMapping("/title/{id}")
	public ResponseEntity<TaskDetailsDto> getTaskTitleById(@PathVariable Long id) throws TaskNotFoundException {
		TaskDetailsDto taskDetailsDto = taskService.getTaskDetailsById(id);
		return new ResponseEntity<>(taskDetailsDto, HttpStatus.OK);
	}
}
