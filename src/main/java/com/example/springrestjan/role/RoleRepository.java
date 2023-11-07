package com.example.springrestjan.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
//    Optional<Role> findFirstByRoleType(RoleType roleType);
    @Query(nativeQuery = true,
            value = "SELECT r.role_name, count(*) as num " +
                    "FROM roles r JOIN users_roles ur ON r.role_id = ur.roles_role_id " +
                    "GROUP BY r.role_name " +
                    "ORDER BY num")
    List<Object[]> aggregateRolesByUsers();
}
