package com.ssocial.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private Integer code;
    private HttpStatus statusCode;
    private String msg;

    public ErrorResponse() { }

    public ErrorResponse(String msg, HttpStatus statusCode, Integer code) {
        this.setMessage(msg);
        this.setStatusCode(statusCode);
        this.setCode(code);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    @JsonProperty("msg")
    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

}
