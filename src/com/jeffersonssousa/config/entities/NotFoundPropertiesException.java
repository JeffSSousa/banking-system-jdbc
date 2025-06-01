package com.jeffersonssousa.config.entities;

public class NotFoundPropertiesException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NotFoundPropertiesException(String msg) {
		super(msg);
	}
}
