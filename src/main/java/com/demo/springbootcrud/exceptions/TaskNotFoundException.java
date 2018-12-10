package com.demo.springbootcrud.exceptions;

/**
 * @author webwerks
 *
 *This exception is thrown when task is searched by id which does not exist.
 */
public class TaskNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public TaskNotFoundException() {

	}
}
