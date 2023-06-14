package com.java.docker.test.util.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Calendar;
import java.util.TimeZone;

@Getter
@Setter
@ToString
public class ErrorMessage {
    private final int statusCode;
    private final String timestamp;
    private final String messageCode;
    private final Object[] params;

    public ErrorMessage(int statusCode, String messageCode, Object[] params) {
        this.statusCode = statusCode;
        this.timestamp = Calendar.getInstance(TimeZone.getDefault()).getTime().toString();
        this.messageCode = messageCode;
        this.params = params;
    }
}
