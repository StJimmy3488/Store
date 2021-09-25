package com.example.store.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor

public class AdminController {

    public String uploadImage() {
        return "/upload_image";
    }



}
