package com.example.board.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

public class Post implements Serializable {

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

    @Serial
    private static final long serialVersionUID = 1L; // 직렬화 버전 명시

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.views = 0L;


    }


}
