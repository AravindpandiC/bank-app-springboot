package com.abc.bankapp.service;

import com.abc.bankapp.entity.Transaction;
import com.abc.bankapp.entity.User;
import com.abc.bankapp.repository.TransactionRepository;
import com.abc.bankapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    public void deposit(double amount,int id){
        User user = userRepository.findById(id).orElseThrow(()-> new  RuntimeException("User not found"));
        user.setBalance(user.getBalance()+amount);
        Transaction transaction = new Transaction();
        transaction.setTransactionType("DEPOSIT");
        transaction.setUser(user);
        transaction.setAmount(amount);

        transactionRepository.save(transaction);
    }

    public void withdraw(double amount,int id){
        User user = userRepository.findById(id).orElseThrow(()-> new  RuntimeException("User not found"));
        double balance = user.getBalance();
        if(amount>=balance) throw new RuntimeException("InsufficientFunds");
        user.setBalance(user.getBalance()-amount);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionType("Withdraw");
        transaction.setUser(user);

        transactionRepository.save(transaction);
    }
}
