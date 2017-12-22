package com.ssocial.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionControllerAdvice {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler({ ControllerException.class })
	@ResponseBody
	private ErrorResponse exceptionHandler(ControllerException ce, HttpServletResponse response) {
		logger.error(ce.getErrorResponse().getMessage());
        logger.error("Controller Exception detected", ce);
		response.setStatus(ce.getErrorResponse().getStatusCode().value());
		return ce.getErrorResponse();
	}

	@ExceptionHandler({ Exception.class })
	@ResponseBody
	private ErrorResponse exceptionHandler(Exception ex, HttpServletResponse response, Integer code) {
        logger.error("Unhandled exception detected", ex);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, code);
	}

}