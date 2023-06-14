package com.java.docker.test.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JSONResponseModel {
    private int status;
    private String message;

    private HashMap<String, ArrayList<JSONObject>> data;
}
