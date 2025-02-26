package com.example.backoffice_java_project.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backoffice_java_project.transaction.dto.UserDto;
import com.example.backoffice_java_project.transaction.service.UserService;

@RestController
@RequestMapping("/backoffice/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsersWithAccount();
    }
}
