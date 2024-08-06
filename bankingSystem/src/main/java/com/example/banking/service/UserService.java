package com.example.banking.service;

import com.example.banking.dto.UserDto;
import com.example.banking.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
