package com.java.docker.test.util.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
public class CustomException extends RuntimeException {

    @Serial
	private static final long serialVersionUID = 1L;

    private int statusCode;
    private Object[] params;

    public CustomException(String message, int statusCode, Object[] params) {
        super(message);
        this.statusCode = statusCode;
        this.params = params;
    }

    public CustomException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;

    }

}
