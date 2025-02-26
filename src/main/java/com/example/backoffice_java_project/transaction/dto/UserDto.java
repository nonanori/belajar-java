package com.example.backoffice_java_project.transaction.dto;

import java.util.List;

public class UserDto {
    private Long id;
    private String fullName;
    private List<AccountDto> accounts;

    public UserDto(Long id, String fullName, List<AccountDto> accounts) {
        this.id = id;
        this.fullName = fullName;
        this.accounts = accounts;
    }

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<AccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }
}
