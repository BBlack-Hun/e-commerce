package kr.co.bblackhun.ecommerce.Login.controller;

import kr.co.bblackhun.ecommerce.User.model.ERole;
import kr.co.bblackhun.ecommerce.User.model.User;
import kr.co.bblackhun.ecommerce.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "Login/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "Login/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, HttpServletRequest request)  throws ServletException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRoles(ERole.ROLE_USER);
        userRepository.save(user);
        request.login(user.getEmail(), password);
        return "redirect:/";

    }
}
