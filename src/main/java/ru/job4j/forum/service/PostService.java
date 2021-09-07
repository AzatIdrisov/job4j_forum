package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post save(Post post) {
        post.setCreated(new Date(System.currentTimeMillis()));
        if (post.getId() != 0) {
            Post currentPost = posts.findPostById(post.getId());
            currentPost.setName(post.getName());
            currentPost.setDesc(post.getDesc());
            posts.save(currentPost);
            return currentPost;
        } else {
            posts.save(post);
            return post;
        }
    }

    public Post update(Post post) {
        Post currentPost = posts.findPostById(post.getId());
        currentPost.setName(post.getName());
        currentPost.setDesc(post.getDesc());
        posts.save(currentPost);
        return currentPost;
    }

    public Post findById(int id) {
        return posts.findPostById(id);
    }
}
