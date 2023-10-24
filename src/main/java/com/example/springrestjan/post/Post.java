package com.example.springrestjan.post;

import com.example.springrestjan.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    private PostCategory postCategory;
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;
}
