package com.java.docker.test.myip.application.service;

import com.java.docker.test.myip.api.dto.ActivityDto;
import com.java.docker.test.myip.api.dto.IpDto;
import org.json.JSONException;

public interface ApiService {
    IpDto getIp();
    ActivityDto getActivity() throws JSONException;
}
