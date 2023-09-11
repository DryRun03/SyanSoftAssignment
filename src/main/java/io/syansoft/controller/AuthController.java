package io.syansoft.controller;

import io.syansoft.domain.JwtRequest;
import io.syansoft.domain.JwtResponse;
//import io.syansoft.security.AuthenticationService;
import io.syansoft.domain.User;
import io.syansoft.repository.UserRepository;
import io.syansoft.security.JWTTokenUtil;
import io.syansoft.service.RedisService;
import io.syansoft.util.URLMappings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(URLMappings.AUTH)
public class AuthController {
    @Autowired private JWTTokenUtil tokenUtil;

    @Autowired private UserRepository userRepository;
    @Autowired private RedisService redisService;
    @Autowired @Lazy
    private AuthenticationManager manager;

    @Autowired private UserDetailsService userDetailsService;
//    @Autowired private AuthenticationService authenticationService;
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping(URLMappings.LOGIN)
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
//        doAuthenticate(request.getUsername(),request.getPassword());
        UserDetails userDetails= userDetailsService.loadUserByUsername(request.getUsername());
        User user = userRepository.findByEmail(request.getUsername());
        String token = tokenUtil.generateTokenWithRoles(userDetails,user);
            user.setToken(token);
            redisService.saveTokenInRedis(user.getUsername(),token);
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .userName(userDetails.getUsername())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email,String password){
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email,password);
        try{
            manager.authenticate(authentication);
        }catch(BadCredentialsException ex){
            throw new RuntimeException("Invalid UserName or Password!!");
        }
    }
}
