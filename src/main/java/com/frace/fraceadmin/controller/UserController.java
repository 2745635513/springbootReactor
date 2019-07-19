package com.frace.fraceadmin.controller;

import com.frace.fraceadmin.domain.User;
import com.frace.fraceadmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/person/save")
    public User save(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name);
        if (userRepository.save(user)){
            System.out.printf("保存的对象： %s 成功 \n",user);
        }
        return user;
    }
}

