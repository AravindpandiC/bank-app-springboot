package com.abc.bankapp.controller;

import com.abc.bankapp.dto.UserDto;
import com.abc.bankapp.service.LogInService;
import com.abc.bankapp.service.TransactionService;
import com.abc.bankapp.service.UserModifyService;
import com.abc.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LogInService logInService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    UserModifyService userModifyService;

    @PostMapping("/add-user")
    public void createUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
    }

    @PutMapping("/user/{id}/deposit/{amount}")
    public void deposit(@PathVariable int id,@PathVariable double amount){
        transactionService.deposit(amount,id);
    }

    @PutMapping("/user/{id}/withdraw/{amount}")
    public void withdraw(@PathVariable int id, @PathVariable double amount){
        transactionService.withdraw(amount,id);
    }

    @PutMapping("/user/{id}/change-name/{name}")
    public void changeName(@PathVariable int id, @PathVariable String name){
        userModifyService.modifyName(name,id);
    }

    @PutMapping("/user/{id}/change-number/{mobile}")
    public void changeMobile(@PathVariable int id,@PathVariable String mobile){
        userModifyService.modifyMobile(mobile,id);
    }
}
