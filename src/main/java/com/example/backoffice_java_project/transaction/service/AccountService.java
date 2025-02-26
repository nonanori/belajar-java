package com.example.backoffice_java_project.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.backoffice_java_project.transaction.entity.Account;
import com.example.backoffice_java_project.transaction.repository.AccountRepo;

@Service
public class AccountService {

    private final AccountRepo accountRepository;
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public AccountService(AccountRepo accountRepository, JdbcTemplate jdbcTemplate) {
        this.accountRepository = accountRepository;
        this.jdbcTemplate = jdbcTemplate;

    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Double getTotalBalanceByUserId(Long userId) {
        String sql = "SELECT COALESCE(SUM(\"BALANCE\"), 0) FROM BACKOFFICE.\"MASTER_ACCOUNT_COBA\" WHERE \"USER_ID\" = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, userId);
    }

}
