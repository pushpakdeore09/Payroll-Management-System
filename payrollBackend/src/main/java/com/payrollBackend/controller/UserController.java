package com.payrollBackend.controller;

import com.payrollBackend.model.User;
import com.payrollBackend.repository.UserRepository;
import com.payrollBackend.request.LoginRequest;
import com.payrollBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/signup")
    public ResponseEntity<String> signup(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<?> signin(@RequestBody LoginRequest loginRequest){
    	
    	String email = loginRequest.getEmail();
    	String password = loginRequest.getPassword();
        ResponseEntity<?> user = userService.loginUser(email, password);

        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
    }
}
