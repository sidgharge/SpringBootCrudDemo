package com.demo.springbootcrud.user.dtos;

/**
 * @author webwerks
 *Dto used as requestbody for create user api.
 */
public class UserCreateDto {

	private String name;

	private String email;

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

}
