package com.gurhan.blogsample.validation;

@SuppressWarnings("serial")
public class EmailExistException extends Throwable {

	public EmailExistException(final String message) {
		super(message);
	}
}
