package com.example.springrestjan.user;

import com.example.springrestjan.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

//@AllArgsConstructor     // dodaje konstruktor z wszystkimi polami jako argumenty
@NoArgsConstructor      // dodaje konstruktor domyślny
//@Getter
//@Setter
//@ToString
@Data                   // dodaje gettery, settery i toString
@Entity
@Table(name = "users")
public class User {
    @Id                                                 // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    private int userId;
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(name = "users_roles",
    joinColumns = @JoinColumn(name = "roles_role_id"),
    inverseJoinColumns = @JoinColumn(name ="users_user_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
