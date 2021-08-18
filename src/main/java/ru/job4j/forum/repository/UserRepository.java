package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(User.of("Admin", "password"));
    }

    public List<User> getAll() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }

}
