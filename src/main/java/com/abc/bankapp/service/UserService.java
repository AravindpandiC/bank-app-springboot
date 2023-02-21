package com.abc.bankapp.service;

import com.abc.bankapp.dto.UserDto;
import com.abc.bankapp.entity.User;
import com.abc.bankapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserDto userDto){
        User user = new User();

        user.setName(userDto.getName());
        System.out.println(userDto.getDob().toString());
        user.setDob(userDto.getDob());
        user.setMobileNo(userDto.getMobileNo());

        userRepository.save(user);
    }
}
