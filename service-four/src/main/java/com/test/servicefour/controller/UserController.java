package com.test.servicefour.controller;

import com.test.servicefour.config.LogMethodParam;
import com.test.servicefour.entity.ResponseDTO;
import com.test.servicefour.entity.User;
import com.test.servicefour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service-four/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    @LogMethodParam
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
}
