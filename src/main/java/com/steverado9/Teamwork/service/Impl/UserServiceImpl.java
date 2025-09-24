package com.steverado9.Teamwork.service.Impl;

import com.steverado9.Teamwork.entity.User;
import com.steverado9.Teamwork.repository.UserRepository;
import com.steverado9.Teamwork.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
