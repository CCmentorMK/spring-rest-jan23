package com.example.springrestjan.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    // SELECT * FROM users WHERE email = ? AND password = ?;
    Optional<User> findByEmailAndPassword(String email, String password);
}
