package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.MessageService;
import ru.job4j.forum.service.PostService;

import java.util.List;

/**
 * @author Azat Idrisov
 * @version 1.0
 * @since 30.08.2021
 */
@Controller
public class MessageControl {
    private final PostService postService;
    private final MessageService messageService;

    public MessageControl(PostService postService, MessageService messageService) {
        this.postService = postService;
        this.messageService = messageService;
    }

    @GetMapping("/post")
    public String post(Model model, @RequestParam int postId) {
        Post post = postService.findById(postId);
        model.addAttribute("post", post);
        List<Message> messages = messageService.findMessagesByPostId(post);
        model.addAttribute("messages", messages);
        model.addAttribute("user", SecurityContextHolder
                .getContext().getAuthentication().getPrincipal());
        return "post";
    }

    @PostMapping("/message/save")
    public String saveMessage(@ModelAttribute Message message, @RequestParam int postId) {
        message.setPost(postService.findById(postId));
        messageService.save(message);
        return "redirect:/post?postId=" + postId;
    }

    @RequestMapping("/message/update")
    public String updateMessage(Model model, @RequestParam int messageId,
                                @RequestParam int postId) {
        Message message = messageService.get(messageId);
        model.addAttribute("message", message);
        model.addAttribute("postId", postId);
        return "message/edit";
    }

    @RequestMapping("/message/delete")
    public String deleteMessage(Model model, @RequestParam int messageId,
                                @RequestParam int postId) {
        messageService.delete(messageId);
        return "redirect:/post?postId=" + postId;
    }
}
