package com.example.springrestjan.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    private RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping("/open-access/role/add-role")
    public List<Role> insertRole(@RequestParam String roleName){
        roleService.insertRole(new Role(roleName));
        return roleService.getRoles();
    }
    @GetMapping("/open-access/role/aggregate")
    public List<Object[]> aggregateRolesByUsers(){
        return roleService.aggregateRolesByUsers();
    }
}
