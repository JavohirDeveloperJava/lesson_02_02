package com.example.lesson_02_02.controller;

import com.example.lesson_02_02.entity.Category;
import com.example.lesson_02_02.entity.Owner;
import com.example.lesson_02_02.payload.CategoryDto;
import com.example.lesson_02_02.payload.OwnerDto;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody CategoryDto dto){
        ApiResponse add = categoryService.add(dto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }

    @GetMapping
    public HttpEntity<List<Category>> get(){
        List<Category> categors = categoryService.get();
        return ResponseEntity.ok(categors);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> put(@PathVariable Integer id, @RequestBody CategoryDto dto){
        ApiResponse put = categoryService.put(id, dto);
        return ResponseEntity.status(put.isSuccess()?201:409).body(put);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delet(@PathVariable Integer id){
        ApiResponse delet = categoryService.delet(id);
        return ResponseEntity.status(delet.isSuccess()?201:409).body(delet);
    }


}
