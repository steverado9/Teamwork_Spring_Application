package com.steverado9.Teamwork.service;

import com.steverado9.Teamwork.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User saveUser(User user);

    User getUserByEmail(String email);

    User getUserById(Long id);
}
