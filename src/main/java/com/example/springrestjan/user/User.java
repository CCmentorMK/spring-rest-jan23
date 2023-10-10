package com.example.springrestjan.user;

import lombok.*;

@AllArgsConstructor     // dodaje konstruktor z wszystkimi polami jako argumenty
@NoArgsConstructor      // dodaje konstruktor domyślny
//@Getter
//@Setter
//@ToString
@Data                   // dodaje gettery, settery i toString
public class User {
    private int userId;
    private String email;
    private String password;

}
