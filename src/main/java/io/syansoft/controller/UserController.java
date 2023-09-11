package io.syansoft.controller;

import io.syansoft.domain.User;
import io.syansoft.repository.UserRepository;
import io.syansoft.service.UserService;
import io.syansoft.util.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(URLMappings.PREFIX + "/user")
public class UserController {

    @Autowired private UserRepository userRepository;
    @Autowired private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        user.setEmail(user.getUsername());
        return userService.addUser(user);
    }

    @GetMapping("/getUserByEmailId")
    public User getUserByEmailId(@RequestParam String email){
        return userService.getUserByEmailId(email);
    }
}
