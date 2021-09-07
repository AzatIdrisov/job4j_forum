package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Message;

/**
 * @author Azat Idrisov
 * @version 1.0
 * @since 30.08.2021
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
    Iterable<Message> findAllByPostIdOrderByCreatedDesc(int id);
}
