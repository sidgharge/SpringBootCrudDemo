package com.demo.springbootcrud.exceptions;

/**
 * @author webwerks
 *
 *This exception is thrown when user is searched by id which does not exist.
 */
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {

	}

}
