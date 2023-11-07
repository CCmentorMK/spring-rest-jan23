package com.example.springrestjan.role;

import java.util.List;

public interface IRoleService {
    void insertRole(Role role);
    List<Role> getRoles();
    List<Object[]> aggregateRolesByUsers();
}
