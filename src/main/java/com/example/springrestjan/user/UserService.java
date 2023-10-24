package com.example.springrestjan.user;

import com.example.springrestjan.role.Role;
import com.example.springrestjan.role.RoleName;
import com.example.springrestjan.role.RoleRepository;
import com.example.springrestjan.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRoleToUser(int userId, RoleName roleName) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Role> roleOptional = roleRepository.findByRole(roleName);

        if(userOptional.isPresent() && roleOptional.isPresent()){
            User user = userOptional.get();
            Role role = roleOptional.get();
            System.out.println(user);
            System.out.println(role);
            Set<Role> roles = user.getRoles();
            roles.add(role);
            user.setRoles(roles);
            userRepository.save(user);                                                       // UPDATE
        }
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "email"));        // mapuje na SQL: SELECT * FROM users;
    }

    @Override
    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);      // mapuje na SQL: DELETE FROM users WHERE user_id = ?;
    }

    @Override
    public List<User> insertUser(User user) {
//        user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByRoleName(0).get())));
        userRepository.save(user);              // mapuje na SQL: INSERT INTO users VALUES (?,?,?,?);
        return getAllUsers();                   // mapuje na SQL: SELECT * FROM users;
    }

    @Override
    public void updateUserById(int userId, String password) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
           User user = userOptional.get();
           user.setPassword(password);
           userRepository.save(user);           // mapuje na SQL: UPDATE users SET password = ?;
        }

    }


}
