package com.example.backoffice_java_project.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backoffice_java_project.transaction.entity.Account;
import com.example.backoffice_java_project.transaction.service.AccountService;

@RestController
@RequestMapping("/backoffice/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/total-balance/{userId}")
    public Double getTotalBalance(@PathVariable Long userId) {
        return accountService.getTotalBalanceByUserId(userId);
    }

}
