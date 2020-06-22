package com.test.servicefour.service;

import com.test.servicefour.entity.ResponseDTO;
import com.test.servicefour.entity.User;
import com.test.servicefour.exception.UserException;
import com.test.servicefour.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) return user.get();
        else throw new UserException("No user found");
    }

    public List<ResponseDTO> getAll() {
        List<User> userList = userRepository.findAll();
        Map<Integer, ResponseDTO> map = new HashMap<>();


        for (User user : userList) {
            ResponseDTO child;
            if (map.containsKey(user.getId())) {
                child = map.get(user.getId());
            } else {
                child = new ResponseDTO();
                map.put(user.getId(), child);
            }
            child.setId(user.getId());
            child.setParentId(user.getParentId());
            child.setName(user.getName());
            child.setColor(user.getColor());

            ResponseDTO parent;
            if (map.containsKey(user.getParentId())) {
                parent = map.get(user.getParentId());
            } else {
                parent = new ResponseDTO();
                map.put(user.getParentId(), parent);
            }
            parent.setId(user.getParentId());
            parent.setChild(child);


        }

        List<ResponseDTO> response = new ArrayList<>();
        map.forEach((key, value) -> {
            if (value.getParentId() != null && value.getParentId() == 0)
                response.add(value);
        });

        return response;
    }
}
