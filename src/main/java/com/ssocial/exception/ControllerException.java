package com.ssocial.exception;

import org.springframework.http.ResponseEntity;

public class ControllerException extends Exception {

	private final ErrorResponse errorResponse;

	public ControllerException(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public ControllerException(String message, ErrorResponse errorResponse) {
		super(message);
		this.errorResponse = errorResponse;
	}

	public ControllerException(String message, Throwable cause,
			ErrorResponse errorResponse) {
		super(message, cause);
		this.errorResponse = errorResponse;
	}

	public ControllerException(ResponseEntity response){
		switch (response.getStatusCode()) {
			default:
				this.errorResponse = ErrorResponses.INTERNAL_SERVER_ERROR;
			break;
		}
	}

	/* Don't know what this method is for, but it's part of the Java API */
	protected ControllerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace,
			ErrorResponse errorResponse) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorResponse = errorResponse;
	}

	public ControllerException(Throwable cause, ErrorResponse errorResponse) {
		super(cause);
		this.errorResponse = errorResponse;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

}
