package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {
    private final PostService service;

    public PostControl(PostService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        service.save(post);
        return "redirect:/index";
    }

    @RequestMapping("/edit")
    public String edit(Model model, @RequestParam(required = false) Integer id) {
        Post post = new Post();
        if (id != null) {
            post = service.findById(id);
        }
        model.addAttribute("post", post);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Post post) {
        service.update(post);
        return "redirect:/index";
    }
}
