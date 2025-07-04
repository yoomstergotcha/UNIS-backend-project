package com.example.board.service;

import com.example.board.domain.Post;
import com.example.board.repository.PostRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setViews(post.getViews() + 1);   // 조회수 증가
        return postRepository.save(post);

    }

    public Post createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post postData) {
        Post post = getPostById(id);
        post.setTitle(postData.getTitle());
        post.setContent(postData.getContent());
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Cacheable(value = "popularPosts")
    public List<Post> getPopularPosts() {
        System.out.println("🔥 인기글 DB에서 조회 중 (캐싱 안 됐을 때만 보임)");
        return postRepository.findTop5ByOrderByViewsDesc();
    }

}


