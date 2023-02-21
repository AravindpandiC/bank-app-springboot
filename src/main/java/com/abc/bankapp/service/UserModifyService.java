package com.abc.bankapp.service;

import com.abc.bankapp.entity.User;
import com.abc.bankapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserModifyService {

    @Autowired
    UserRepository userRepository;

    public void modifyName(String name,int id){
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        user.setName(name);
        userRepository.save(user);
    }

    public void modifyMobile(String mobile,int id){
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        user.setMobileNo(mobile);
        userRepository.save(user);
    }
}
