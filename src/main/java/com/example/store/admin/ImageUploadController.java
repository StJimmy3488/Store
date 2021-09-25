package com.example.store.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ImageUploadController {

    private final ImageUploadService imageUploadService;

    @GetMapping("/add_image")
    public String addImage() {
        return "/admin/upload_image";
    }

    @PostMapping("/upload_image")
    public String upload_image(@RequestParam("imageFile") MultipartFile imageFile) {
        String returnValue = "/admin/upload_image";
        try {
            imageUploadService.saveImage(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error saving image", e);
            returnValue = "error";
        }
        return "redirect:/admin/add_image";
    }


}
