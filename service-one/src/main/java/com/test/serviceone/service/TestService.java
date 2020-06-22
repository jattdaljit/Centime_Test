package com.test.serviceone.service;

import com.test.serviceone.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${service.two.url}")
    private String serviceTwoUrl;

    @Value(value = "${service.three.url}")
    private String serviceThreeUrl;


    public String getStatus() {
        return "UP";
    }

    public String getResponse(User user) {
        return invokeServiceTwo() + " " + invokeServiceThree(user);
    }

    private String invokeServiceTwo() {
        return restTemplate.getForEntity(serviceTwoUrl + "service-two", String.class).getBody();
    }

    private String invokeServiceThree(User user) {
        HttpEntity<User> request = new HttpEntity<>(user);
        return restTemplate.postForObject(serviceThreeUrl + "service-three", request, String.class);
    }
}
