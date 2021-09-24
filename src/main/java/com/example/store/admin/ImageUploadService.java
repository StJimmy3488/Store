package com.example.store.admin;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class ImageUploadService {
    public void saveImage(MultipartFile imageFile) throws Exception {
        String folder = "C:\\Users\\dator\\IdeaProjects\\Store\\src\\main\\resources\\static\\images\\product_images";
        byte[] bytes = imageFile.getBytes();
        Path path =  Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }
}
