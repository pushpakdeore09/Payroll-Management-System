package com.payrollBackend.controller;

import com.payrollBackend.model.User;
import com.payrollBackend.repository.UserRepository;
import com.payrollBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    public ResponseEntity<String> signin(@RequestParam String email, @RequestParam String password){
        ResponseEntity<?> user = userService.loginUser(email, password);

        if(user != null){
            return ResponseEntity.ok("Login Successful");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}
