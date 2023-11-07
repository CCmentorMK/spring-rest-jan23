package com.example.springrestjan.role;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
//    @Enumerated(value = EnumType.STRING)
//    private RoleType roleType;
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
