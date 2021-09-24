package com.example.store.admin.imageupload;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class ImageUploadController {

    private FileUploadService fileUploadService;

    private ImageService imageService;

    @GetMapping("/add_image")
    public String uploadImage() {
        return "admin/upload_image";
    }

    @PostMapping("/upload_mage")
    public String uploadImage(@RequestParam("image") MultipartFile imageFile, RedirectAttributes redirectAttributes) {
        if(imageFile.isEmpty()) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "Please choose file to upload.");
            return "redirect:/";
        }

        File file = fileUploadService.upload(imageFile);
        if(file == null) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "Upload failed.");
            return "redirect:/";

        }
        boolean resizeResult =  imageService.resizeImage(file);
        if(!resizeResult) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "Resize failed.");
            return "redirect:/";
        }

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "File upload successfully.");
        return "redirect:/";
    }
}
