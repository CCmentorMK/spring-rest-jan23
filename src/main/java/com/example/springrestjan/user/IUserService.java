package com.example.springrestjan.user;

import com.example.springrestjan.role.RoleType;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    void deleteUserById(int userId);
    List<User> insertUser(User user);
    void updateUserById(int userId, String password);
//    void addRoleToUser(int userId, RoleType roleType);
    void addRoleToUser(int userId, int roleId);
}
