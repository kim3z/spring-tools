package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadController {

    private static String UPLOAD_DIR = System.getProperty("user.dir") + "\\";

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Uploaded file: " + file.getOriginalFilename();
    }

}
