package com.example.store.admin.imageupload;

import com.example.store.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ImageUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private ImageService imageService;

    private final ProductService productService;

    @GetMapping("/add_image")
    public String addImage() {
        return "/upload_image";
    }

    @PostMapping("/upload_image")
    public String uploadImage(@RequestParam("newImage") MultipartFile imageFile,
                              RedirectAttributes redirectAttributes) {
        if (imageFile.isEmpty()) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "Please choose file to upload.");
            return "/admin/upload_image";
        }

        File file = fileUploadService.upload(imageFile);
        if (file == null) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "Upload failed.");
            return "admin/upload_image";

        }
        boolean resizeResult = imageService.resizeImage(file);
        if (!resizeResult) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "Resize failed.");
            return "admin/upload_image";
        }

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "File upload successfully.");
        return "admin/upload_image";
    }
}
