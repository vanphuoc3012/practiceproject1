package com.likelion.springdatajdbc.repository;

import com.likelion.springdatajdbc.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account save(Account account) {
        jdbcTemplate.update(
                "INSERT INTO Account (id, name, amount) VALUES (?, ?, ?)",
                account.getId(),
                account.getName(),
                account.getAmount()
        );
        return account;
    }

    @Override
    public Optional<Account> findAccountById(Long id) {
        List<Account> results = jdbcTemplate.query(
                "SELECT * FROM account WHERE id = ?",
                this::mapRowToAccount, id
        );
        return results.size() == 0 ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public List<Account> findAllAccountsByName(String name) {
        return jdbcTemplate.query(
                "SELECT * FROM account WHERE name=?",
                this::mapRowToAccount
        );
    }


    private Account mapRowToAccount(ResultSet resultSet, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getLong("id"));
        account.setName(resultSet.getString("name"));
        account.setAmount(resultSet.getBigDecimal("amount"));

        return account;
    }
}
