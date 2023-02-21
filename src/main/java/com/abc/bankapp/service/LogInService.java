package com.abc.bankapp.service;

import com.abc.bankapp.entity.User;
import com.abc.bankapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    @Autowired
    UserRepository userRepository;

    public String logIn(int id){
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        return "Logged in successfully";
    }
}
