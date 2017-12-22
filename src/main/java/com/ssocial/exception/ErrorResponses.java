package com.ssocial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponses extends ErrorResponse {

    public static final ErrorResponses INTERNAL_SERVER_ERROR = new ErrorResponses("Internal error please try again. If the error persist contact us to solve the problem", HttpStatus
        .INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());

    public ErrorResponses() {
    }


    public ErrorResponses(String message, HttpStatus httpStatus, Integer code) {
        super(message, httpStatus, code);
    }

}