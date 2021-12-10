package com.example.validationform.service;

import com.example.validationform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserById(Integer id);
}
