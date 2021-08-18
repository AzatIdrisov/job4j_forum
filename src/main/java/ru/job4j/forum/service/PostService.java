package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {
    private final Map<Integer, Post> posts = new HashMap<>();
    private final AtomicInteger id = new AtomicInteger(0);

    public PostService() {
        save(Post.of("Первый пост"));
    }

    public List<Post> getAll() {
        return new ArrayList<>(posts.values());
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            post.setId(id.getAndIncrement());
        }
        posts.put(post.getId(), post);
        return post;
    }

    public Post findById(int id) {
        return posts.get(id);
    }
}
