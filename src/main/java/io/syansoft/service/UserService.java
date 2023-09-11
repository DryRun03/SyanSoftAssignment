package io.syansoft.service;

import io.syansoft.domain.User;
import io.syansoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    @Autowired private PasswordEncoder passwordEncoder;
    public User addUser(User user){
        User userDb = userRepository.findByEmail(user.getEmail());
        if(Objects.isNull(userDb)){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
        return null;
    }

    public User getUserByEmailId(String email) {
        return userRepository.findByEmail(email);
    }
}
