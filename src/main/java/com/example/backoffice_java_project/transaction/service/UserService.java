package com.example.backoffice_java_project.transaction.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.backoffice_java_project.transaction.repository.UserRepo;
import com.example.backoffice_java_project.transaction.dto.AccountDto;
import com.example.backoffice_java_project.transaction.dto.UserDto;
import com.example.backoffice_java_project.transaction.entity.User;

@Service
public class UserService {

    private final UserRepo userRepository;

    @Autowired
    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserDto> getAllUsersWithAccount() {
        return userRepository.findAll().stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getFullName(),
                        user.getAccounts() != null
                                ? user.getAccounts().stream()
                                        .map(account -> new AccountDto(account.getId(), account.getBalance()))
                                        .collect(Collectors.toList())
                                : List.of()))
                .collect(Collectors.toList());
    }

    public String checkUserById(Long id) {
        if (userRepository.existsById(id)) {
            return "User dengan ID " + id + " ditemukan";
        } else {
            return "User dengan ID " + id + " tidak ada";
        }
    }
}
