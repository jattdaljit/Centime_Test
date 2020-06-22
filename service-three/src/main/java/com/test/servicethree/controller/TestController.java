package com.test.servicethree.controller;

import com.test.servicethree.model.User;
import com.test.servicethree.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("service-three")
public class TestController {

    private static final Logger LOGGER = Logger.getLogger(TestController.class.getName());

    @Autowired
    private TestService testService;

    @PostMapping
    public ResponseEntity<String> getConcatResponse(@RequestBody User user) {
        LOGGER.info(user.toString());
        return new ResponseEntity<String>(testService.concatName(user), HttpStatus.OK);
    }
}
