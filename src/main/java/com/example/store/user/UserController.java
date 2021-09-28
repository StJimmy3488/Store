package com.example.store.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {


    private final UserService userService;
    private final CustomUserDetailsService customUserDetailsService;


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "user/registration_form";
    }


//TODO- Must be updated

//    @PostMapping("/process_register")
//    public String processRegister(User user) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getUserPassword());
//        user.setUserPassword(encodedPassword);
//        customUserDetailsService.registerUser(user);
//
//        return "user/register_success";
//    }

//TODO - must be updated 'list all users'

//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public String list(@PageableDefault(size = 8, direction = Sort.Direction.ASC, sort = "username") Pageable pageable, Model model) {
//        model.addAttribute("users", userService.findAllUsers(pageable));
//        return "user/user_list";
//    }


}
