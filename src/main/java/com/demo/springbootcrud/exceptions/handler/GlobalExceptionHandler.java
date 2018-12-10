package com.demo.springbootcrud.exceptions.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.springbootcrud.exceptions.TaskNotFoundException;
import com.demo.springbootcrud.task.dtos.CustomResponse;

/**
 * @author webwerks
 *
 *Global Exception handler class.
 *All the exceptions are captured here and appropriate response is sent to the client
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * Handles TaskNotFoundException.
	 * @param 
	 * @return
	 */
	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<CustomResponse> handleTaskNotFoundException(TaskNotFoundException exception) {
		logger.info("Task not found", exception);
		
		CustomResponse customResponse = new CustomResponse(-2, "Task not found with given id");
		return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handles RuntimeException
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<CustomResponse> handleException(Exception exception) {
		logger.error(exception.getMessage(), exception);
		
		CustomResponse customResponse = new CustomResponse(-1, "Something went wrong");
		return new ResponseEntity<>(customResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
