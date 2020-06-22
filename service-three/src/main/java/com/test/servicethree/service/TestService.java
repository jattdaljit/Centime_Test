package com.test.servicethree.service;

import com.test.servicethree.model.User;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String concatName(User user) {
        String name = user.getName();
        String surname = user.getSurname();

        if (name != null && surname != null) {
            return name + " " + surname;
        } else if (name != null && surname == null) {
            return name;
        } else if (name == null && surname != null) {
            return surname;
        } else {
            return "";
        }
    }
}
