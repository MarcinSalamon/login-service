package com.example.login.exceptions;

public class LoginException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
