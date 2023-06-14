package com.java.docker.test.myip.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.docker.test.myip.api.dto.ActivityDto;
import com.java.docker.test.myip.api.dto.IpDto;
import com.java.docker.test.myip.application.service.ApiService;
import com.java.docker.test.util.RequestMappingPrefixPath;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {

    @Autowired
    ApiService apiService;

    private final ObjectMapper objectMapper;

    public ApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @GetMapping(path = "/")
    public String getUser() {
        return "hello";
    }

    @GetMapping(path = RequestMappingPrefixPath.api + "/ip")
    public IpDto getIp() {
        return apiService.getIp();
    }

    @GetMapping(path = RequestMappingPrefixPath.api + "/activity")
    public ActivityDto getActivity() throws JSONException {
        return apiService.getActivity();
    }
}
