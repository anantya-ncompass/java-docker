package com.java.docker.test.myip.infrastructure.repository;

import com.java.docker.test.util.httpclient.HttpGetUtilities;
import com.java.docker.test.util.httpclient.HttpclientResult;

import org.springframework.stereotype.Repository;


import static com.java.docker.test.myip.CONST.BORED_API;
import static com.java.docker.test.myip.CONST.MY_IP_API;

@Repository
public class ApiRepositoryImpl implements ApiRepository{
    @Override
    public String getIp() {
        HttpclientResult response = HttpGetUtilities.GET(MY_IP_API);
        return  response.getResponseString();
    }

    @Override
    public String getActivity() {
        HttpclientResult response = HttpGetUtilities.GET(BORED_API);
        return  response.getResponseString();
    }


}
