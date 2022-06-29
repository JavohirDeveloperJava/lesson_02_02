package com.example.lesson_02_02.controller;

import com.example.lesson_02_02.entity.Attechment;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.service.AttechmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping("/api/attechment")
public class AttechmentController {
    @Autowired
    AttechmentService attechmentService;
    @PostMapping("/uploadd")
    public ApiResponse uploadFile(MultipartHttpServletRequest request){
        return attechmentService.add(request);
    }
}
