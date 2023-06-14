package com.java.docker.test.myip.application.service;

import com.java.docker.test.myip.api.dto.ActivityDto;
import com.java.docker.test.myip.api.dto.IpDto;
import com.java.docker.test.myip.infrastructure.repository.ApiRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiServiceImpl implements ApiService{

    @Autowired
    ApiRepository apiRepository;

    @Override
    public IpDto getIp() {
        String jsonString = apiRepository.getIp();
        IpDto ipDto = new IpDto();
        ipDto.setIp(extractIp(jsonString));
        return ipDto;
    }

    @Override
    public ActivityDto getActivity() throws JSONException {
        String jsonString = apiRepository.getActivity();

        ActivityDto activityDto = new ActivityDto();
        JSONObject jsonObject = new JSONObject(jsonString);

        String activity = jsonObject.getString("activity");
        String type = jsonObject.getString("type");
        int participants = jsonObject.getInt("participants");
        double price = jsonObject.getDouble("price");
        String key = jsonObject.getString("key");
        double accessibility = jsonObject.getDouble("accessibility");

        activityDto.setActivity(activity);
        activityDto.setType(type);
        activityDto.setParticipants(participants);
        activityDto.setPrice(price);
        activityDto.setKey(key);
        activityDto.setAccessibility(accessibility);
       return activityDto;
    }

    public static String extractIp(String jsonString) {
        int startIndex = jsonString.indexOf(":") + 2;
        int endIndex = jsonString.lastIndexOf("\"");
        return jsonString.substring(startIndex, endIndex);
    }
}
