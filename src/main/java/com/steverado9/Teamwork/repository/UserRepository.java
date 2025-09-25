package com.steverado9.Teamwork.repository;

import com.steverado9.Teamwork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
