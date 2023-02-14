package com.likelion.springdatajdbc.repository;

import com.likelion.springdatajdbc.model.Account;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    @Transactional
    Account save(Account account);

    Optional<Account> findAccountById(Long id);

    List<Account> findAllAccountsByName(String name);
}
