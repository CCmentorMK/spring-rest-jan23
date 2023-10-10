package com.example.springrestjan.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    // wstrzyknięcie zależności do klasy UserService!
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello(){
        return "hello!!!";
    }
//    @GetMapping("/admin-access/user/getusers")
//    ...
    @GetMapping("/open-access/user/get-users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/open-access/user/add-user")
    public List<User> addUser(
            @RequestParam("userid") int userId,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        return userService.insertUser(new User(userId,email,password));
    }
    @PatchMapping("/open-access/user/update-password")
    public void updateUserPassword(
            @RequestParam("userid") int userId,
            @RequestParam("password") String password
    ){
        userService.updateUserById(userId, password);
    }
    @DeleteMapping("/open-access/user/delete-user")
    public void deteleUser(
            @RequestParam("userid") int userId
    ){
        userService.deleteUserById(userId);
    }
}
