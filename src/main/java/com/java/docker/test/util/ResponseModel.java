package com.java.docker.test.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModel {
    private Object data;


    public ResponseModel(Object data) {
        this.data = data;
    }
}
