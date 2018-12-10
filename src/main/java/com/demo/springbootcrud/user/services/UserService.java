package com.demo.springbootcrud.user.services;

import com.demo.springbootcrud.exceptions.UserNotFoundException;
import com.demo.springbootcrud.user.dtos.UserCreateDto;
import com.demo.springbootcrud.user.dtos.UserDto;
import com.demo.springbootcrud.user.models.User;

/**
 * @author webwerks
 *
 *This service is used for user related operations
 */
public interface UserService {

	/**
	 * Creates a new user and saves into the database
	 * @param userCreateDto - dto representing user to be created
	 * @return UserDto, representation of the created user
	 */
	UserDto addUser(UserCreateDto userCreateDto);

	/**
	 * Returns user with given id
	 * @param userId - user identifier of the user
	 * @return - user with given id
	 * @throws UserNotFoundException - thrown when user does not exist by given id
	 */
	User getUserById(Long userId) throws UserNotFoundException;

	/**
	 * Returns user with given id
	 * @param userId - user identifier of the user
	 * @return - user with given id
	 * @throws UserNotFoundException - thrown when user does not exist by given id
	 */
	UserDto getCompleteUser(Long id) throws UserNotFoundException;

}
