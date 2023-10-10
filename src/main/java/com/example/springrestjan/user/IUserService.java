package com.example.springrestjan.user;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    void deleteUserById(int userId);
    List<User> insertUser(User user);
    void updateUserById(int userId, String password);
}
