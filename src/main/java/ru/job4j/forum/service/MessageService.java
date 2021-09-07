package ru.job4j.forum.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.MessageRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Azat Idrisov
 * @version 1.0
 * @since 30.08.2021
 */
@Service
public class MessageService {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Message save(Message message) {
        message.setCreated(Calendar.getInstance());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        message.setAuthor(user.getUsername());
        if (message.getId() != 0) {
            Message ms = get(message.getId());
            message.setCreated(ms.getCreated());
        }
        repository.save(message);
        return message;
    }

    public Message get(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(int id) {
        Message message = new Message();
        message.setId(id);
        repository.delete(message);
    }

    public List<Message> findMessagesByPostId(Post post) {
        List<Message> messages = new ArrayList<>();
        repository.findAllByPostIdOrderByCreatedDesc(post.getId()).forEach(messages::add);
        return messages;
    }
}
