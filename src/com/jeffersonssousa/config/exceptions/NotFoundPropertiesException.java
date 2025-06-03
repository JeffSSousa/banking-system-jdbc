package com.jeffersonssousa.config.exceptions;

public class NotFoundPropertiesException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NotFoundPropertiesException(String msg) {
		super(msg);
	}
}
