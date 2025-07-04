package com.example.board.controller;

import com.example.board.domain.Post;
import com.example.board.service.PostService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

//    @PostMapping
//    public Post createPost(@RequestBody Post post) {
//        return postService.createPost(post);
//    }
    @PostMapping("/batch")
    public List<Post> createPosts(@RequestBody List<Post> posts) {
        return posts.stream()
                .map(postService::createPost)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @GetMapping("/popular")
    public List<Post> getPopularPosts() {
        return postService.getPopularPosts();
    }

    @CacheEvict(value = "popularPosts", allEntries = true)
    @PostMapping("/reset-cache")
    public void resetPopularPostCache() {
        System.out.println("🧹 인기글 캐시 초기화됨");
    }

}
