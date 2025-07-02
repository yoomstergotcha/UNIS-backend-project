package com.example.board.repository;

import com.example.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findTop5ByOrderByViewsDesc();
}
