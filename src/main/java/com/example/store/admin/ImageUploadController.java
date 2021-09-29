package com.example.store.admin;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/admin")
public class ImageUploadController {

    private static final String productId = "001";
    private static final String categoryId = "001";
    private static final String imageSize = "128";

    private String UPLOAD_DIR = "src/main/resources/static/images/product_images/";

//    File theDir = new File(UPLOAD_DIR + productId);
//    if(!theDir.exists()) {theDir.mkdirs(); }


    @GetMapping("/upload_image")
    public String homepage() {
        return "admin/upload_image";
    }


    @PostMapping("/upload")
    public String uploadFile(@RequestParam("image_file") MultipartFile file,
                             HttpServletRequest request,
                             RedirectAttributes attributes) throws ServletException, IOException {

        // Check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/admin/upload_image";
        }

        // Normalizing the file path and renaming the uploaded file
        // FileName = filePart.getSubmittedFileName();
        Part filePart = request.getPart("image_file");
        // Full name of file submitted
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // Split between name and extension
        String[] fileNameSplit = fileName.split("\\.");
        // Get the extension part of the file name
        String fileExtension = fileNameSplit[fileNameSplit.length - 1];
        // Combine all filename parts together
        fileName = productId + categoryId + imageSize + "." + fileExtension;

        // Save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return success response
        attributes.addFlashAttribute("message", "Image <b>" + fileName + "</b> successfully uploaded to directory " + UPLOAD_DIR + "!");

        return "redirect:/admin/upload_image";
    }

}
