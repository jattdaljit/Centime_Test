package com.test.servicetwo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service-two")
public class TestController {

    @GetMapping
    public String getResponse(){
        return "Hello";
    }
}
