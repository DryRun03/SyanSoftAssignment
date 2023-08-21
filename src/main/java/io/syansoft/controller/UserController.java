package io.syansoft.controller;

import io.syansoft.domain.User;
import io.syansoft.repository.UserRepository;
import io.syansoft.util.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(URLMappings.PREFIX + "/user")
public class UserController {

    @Autowired private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @PostMapping("/")
    public User addUser(User user){
        return userRepository.save(user);
    }
}
