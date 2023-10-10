package com.example.springrestjan.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface UserRepository {
    List<User> USERS = new ArrayList<>(Arrays.asList(
        new User(1, "a@a.pl", "aaa"),
        new User(2, "b@b.pl", "bbb"),
        new User(3, "c@c.pl", "ccc")
    ));
}
