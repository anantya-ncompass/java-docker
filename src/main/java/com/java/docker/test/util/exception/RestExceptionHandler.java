package com.java.docker.test.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<ErrorMessage> handleCustomException(CustomException ex) {
        LOG.error(ex.getMessage(), ex);
        ErrorMessage error = new ErrorMessage(ex.getStatusCode(), ex.getMessage(), ex.getParams());
        return new ResponseEntity<>(error, HttpStatus.valueOf(ex.getStatusCode()));
    }

    @ExceptionHandler(NoDataError.class)
    public final ResponseEntity<ErrorMessage> handleNoDataException(NoDataError ex) {
        LOG.error(ex.getMessage(), ex);
        ErrorMessage error = new ErrorMessage(404, ex.getMessage(), new Object[]{});
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

}
