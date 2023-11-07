package com.example.springrestjan.user;

import com.example.springrestjan.role.RoleType;
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

    @GetMapping("/open-access/user/get-users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/open-access/user/add-user")
    public List<User> addUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        return userService.insertUser(new User(email,password));
    }
    @PatchMapping("/open-access/user/update-password")
    public void updateUserPassword(
            @RequestParam("user_id") int userId,
            @RequestParam("password") String password
    ){
        userService.updateUserById(userId, password);
    }
    @PutMapping("/open-access/user/add-role")
    public void addRoleToUser(
            @RequestParam("user_id") int userId,
            @RequestParam("role_id") int roleId
    ){
        userService.addRoleToUser(userId, roleId);
    }
    @DeleteMapping("/open-access/user/delete-user")
    public void deteleUser(
            @RequestParam("userid") int userId
    ){
        userService.deleteUserById(userId);
    }
}
