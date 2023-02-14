package com.likelion.springdatajdbc.controller;

import com.likelion.springdatajdbc.model.Account;
import com.likelion.springdatajdbc.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountRestController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/")
    public ResponseEntity<?> test() {
        Account account = new Account(1l, "Account 1", new BigDecimal(10000));

        accountRepository.save(account);

        Account savedAccount = accountRepository.findAccountById(1l).get();
        return new ResponseEntity<>(savedAccount, HttpStatus.OK);
    }
}
