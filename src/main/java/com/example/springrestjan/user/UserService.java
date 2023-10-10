package com.example.springrestjan.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Override
    public List<User> getAllUsers() {
        return UserRepository.USERS;
    }

    @Override
    public void deleteUserById(int userId) {
        UserRepository.USERS.remove(UserRepository.USERS.stream().filter(user -> user.getUserId() == userId).findFirst().get());
    }

    @Override
    public List<User> insertUser(User user) {
        UserRepository.USERS.add(user);
        return UserRepository.USERS;
    }

    @Override
    public void updateUserById(int userId, String password) {
        UserRepository.USERS.stream().filter(user -> user.getUserId() == userId).findFirst().get().setPassword(password);
    }
}
