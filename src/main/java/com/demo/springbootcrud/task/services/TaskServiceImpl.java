package com.demo.springbootcrud.task.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springbootcrud.exceptions.TaskNotFoundException;
import com.demo.springbootcrud.exceptions.UserNotFoundException;
import com.demo.springbootcrud.task.dtos.TaskCreateDto;
import com.demo.springbootcrud.task.dtos.TaskDetailsDto;
import com.demo.springbootcrud.task.dtos.TaskDto;
import com.demo.springbootcrud.task.dtos.TaskSummary;
import com.demo.springbootcrud.task.models.Task;
import com.demo.springbootcrud.task.models.TaskHistory;
import com.demo.springbootcrud.task.repositories.TaskHistoryRepository;
import com.demo.springbootcrud.task.repositories.TaskRepository;
import com.demo.springbootcrud.user.models.User;
import com.demo.springbootcrud.user.services.UserService;

/**
 * @author webwerks
 *Implementation of the {@link TaskService}
 *@see TaskService
 */
@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskHistoryRepository taskHistoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserService userService;

	@Override
	public TaskDto createTask(TaskCreateDto taskCreateDto) throws UserNotFoundException {
		Task task = modelMapper.map(taskCreateDto, Task.class);
		task.setId(null);
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		task.setCreatedAt(currentTime);
		task.setUpdatedAt(currentTime);
		
		User user = userService.getUserById(taskCreateDto.getUserId());
		
		task.setUser(user);
		
		taskRepository.save(task);
		
		TaskHistory h = createTaskHistory("SAVE", task);
		taskHistoryRepository.save(h);
		
		return modelMapper.map(task, TaskDto.class);
	}

	@Override
	public TaskDto updateTask(TaskDto taskDto) throws TaskNotFoundException {
		Optional<Task> optionalTask = taskRepository.findById(taskDto.getId());
		
		return optionalTask.map(task -> {
			task.setTitle(taskDto.getTitle());
			task.setBody(taskDto.getBody());
			task.setUpdatedAt(LocalDateTime.now());
			
			taskRepository.save(task);
			
			TaskHistory h = createTaskHistory("UPDATE", task);
			
			taskHistoryRepository.save(h);
			
			return modelMapper.map(task, TaskDto.class);
		}).orElseThrow(() -> new TaskNotFoundException());
	}

	@Override
	public List<TaskDto> getAllTasks() {
		return taskRepository.findAll()
			.stream()
			.map(task -> modelMapper.map(task, TaskDto.class))
			.collect(Collectors.toList());
	}

	@Override
	public TaskDto getTaskById(Long id) throws TaskNotFoundException {
		return taskRepository.findById(id)
			.map(task -> modelMapper.map(task, TaskDto.class))
			.orElseThrow(() -> new TaskNotFoundException());
	}
	

	@Override
	public TaskDetailsDto getTaskDetailsById(Long id) throws TaskNotFoundException {
		return taskRepository.findById(id)
				.map(this::mapTaskToTaskDetailsDto)
				.orElseThrow(() -> new TaskNotFoundException());
	}
	
	private TaskDetailsDto mapTaskToTaskDetailsDto(Task task) {
		TaskDetailsDto taskDetailsDto = new TaskDetailsDto();
		taskDetailsDto.setBody(task.getBody());
		taskDetailsDto.setUpdatedAt(task.getUpdatedAt());
		
		TaskSummary summary = new TaskSummary();
		summary.setId(task.getId());
		summary.setTitle(task.getTitle());
		
		taskDetailsDto.setTaskSummary(summary);
		
		return taskDetailsDto;
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
	
	private TaskHistory createTaskHistory(String operation, Task task) {
		TaskHistory history = new TaskHistory();
		history.setOperation(operation);
		history.setTask(task);
		
		return history;
	}

}
