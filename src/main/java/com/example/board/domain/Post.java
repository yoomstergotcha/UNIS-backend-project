package com.example.board.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition="TEXT")
    private String content;

    private String author;

    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Long views;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.views = 0L;
    }


}
