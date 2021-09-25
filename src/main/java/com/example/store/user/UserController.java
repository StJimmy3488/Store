package com.example.store.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {


    private final UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "registration_form";
    }

//    @GetMapping("/sign_in")
//    public String signIn() {
//        return "/user/login_form";
//    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(encodedPassword);
        userService.saveOrUpdateUser(user);

        return "register_success";
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(@PageableDefault(size = 8, direction = Sort.Direction.ASC, sort = "username") Pageable pageable, Model model) {
        model.addAttribute("users", userService.findAllUsers(pageable));
        return "user_list";
    }
}
