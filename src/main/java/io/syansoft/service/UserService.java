package io.syansoft.service;

import io.syansoft.domain.User;
import io.syansoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;
    public User addUser(User user){
        User userDb = userRepository.findByEmail(user.getEmail());
        if(Objects.isNull(userDb)){
            return userRepository.save(user);
        }
        return null;
    }

    public User getUserByEmailId(String email) {
        return userRepository.findByEmail(email);
    }
}
