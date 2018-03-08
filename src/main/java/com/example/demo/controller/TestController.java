package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

    @PostMapping("/run")
    public String run(@RequestParam("filepath") String filePath) {

        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec("java -jar " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Path: " + filePath;
    }

}
