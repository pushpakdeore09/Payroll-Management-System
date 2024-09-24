package com.payrollBackend.service;

import com.payrollBackend.model.User;
import com.payrollBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> createUser(User user){
        User isExist = userRepository.findByEmail(user.getEmail());

        if(isExist!=null){
           return new ResponseEntity<>("User already exists with this email address", HttpStatus.CONFLICT);
        }

        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        userRepository.save(newUser);
        return new ResponseEntity<>("Register Successfully", HttpStatus.CREATED);
    }

    public User loginUser(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
