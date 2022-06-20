package com.alodat.m.service;

import com.alodat.m.dto.UserDto;
import com.alodat.m.model.User;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}