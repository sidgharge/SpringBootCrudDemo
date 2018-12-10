package com.demo.springbootcrud.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootcrud.exceptions.UserNotFoundException;
import com.demo.springbootcrud.user.dtos.UserCreateDto;
import com.demo.springbootcrud.user.dtos.UserDto;
import com.demo.springbootcrud.user.services.UserService;

/**
 * @author webwerks
 *Controller contains all the apis related to user
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * Saves new user into the database
	 * @param userCreateDto - dto representing new user
	 * @return - representation of the created user
	 */
	@PostMapping
	public UserDto addUser(@RequestBody UserCreateDto userCreateDto) {
		return userService.addUser(userCreateDto);
	}
	
	/**
	 * Returns user details of user with given id
	 * @param id - identifier of the user
	 * @return representation of the user with given id
	 * @throws UserNotFoundException - thrown when user does not exists for given id
	 */
	@GetMapping("/detailed/{id}")
	public UserDto getCompleteUser(@PathVariable Long id) throws UserNotFoundException {
		return userService.getCompleteUser(id);
	}
}
