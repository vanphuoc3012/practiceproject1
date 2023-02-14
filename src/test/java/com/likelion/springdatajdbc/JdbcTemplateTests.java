package com.likelion.springdatajdbc;

import com.likelion.springdatajdbc.model.Account;
import com.likelion.springdatajdbc.repository.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.math.BigDecimal;

@DataJdbcTest
public class JdbcTemplateTests {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void testJdbcTemplate() {
        Account account = new Account(1l, "Account 1", new BigDecimal(10000));

        accountRepository.save(account);

        Account savedAccount = accountRepository.findAccountById(1l).get();
        Assertions.assertThat(savedAccount.getId()).isEqualTo(1l);
    }
}
