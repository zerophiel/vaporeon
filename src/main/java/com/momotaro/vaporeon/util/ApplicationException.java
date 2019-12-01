package com.momotaro.vaporeon.util;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {

    private HttpStatus httpStatus;
    private String code;
    private String message;

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
        this.message = message;
    }

    public ApplicationException(String code, String message) {
        super("[" + code + "] " + message);
        this.code = code;
        this.message = message;
    }

    public ApplicationException(HttpStatus httpStatus, String code, String message) {
        super("[" + code + "] " + message);
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApplicationException{" + "code='" + code + '\'' + ", message='" + message + '\'' + '}';
    }
}
