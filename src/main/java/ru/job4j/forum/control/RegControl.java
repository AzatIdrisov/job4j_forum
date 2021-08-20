package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.AuthorityRepository;
import ru.job4j.forum.repository.UserRepository;

@Controller
public class RegControl {
    private final UserRepository users;
    private final PasswordEncoder encoder;
    private final AuthorityRepository authorities;

    public RegControl(UserRepository users,
                      PasswordEncoder encoder,
                      AuthorityRepository authorities) {
        this.users = users;
        this.encoder = encoder;
        this.authorities = authorities;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        String errorMessage = null;
        if (users.findUsersByUsername(user.getUsername()) != null) {
            errorMessage = "User with such name is already exist";
            model.addAttribute("errorMessage", errorMessage);
            return "reg";
        } else {
            user.setEnabled(true);
            user.setPassword(encoder.encode(user.getPassword()));
            user.setAuthority(authorities.findByAuthority("ROLE_USER"));
            users.save(user);
            return "redirect:/login";
        }
    }

    @GetMapping("/reg")
    public String reg(@ModelAttribute User user) {
        return "reg";
    }
}
