package com.demo.springbootcrud.task.dtos;

/**
 * @author webwerks
 *
 *Dto is used for sending custom response, specially in case of errors
 */
public class CustomResponse {

	private int status;

	private String message;

	public CustomResponse() {

	}

	public CustomResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
