package com.example.lesson_02_02.controller;

import com.example.lesson_02_02.entity.Category;
import com.example.lesson_02_02.entity.Product;
import com.example.lesson_02_02.payload.CategoryDto;
import com.example.lesson_02_02.payload.ProductDto;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping
    public HttpEntity<?> add(@RequestBody ProductDto dto){
        ApiResponse add = productService.add(dto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }

    @GetMapping
    public HttpEntity<List<Product>> get(){
        List<Product> products = productService.get();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> put(@PathVariable Integer id, @RequestBody ProductDto dto){
        ApiResponse put = productService.put(id, dto);
        return ResponseEntity.status(put.isSuccess()?201:409).body(put);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delet(@PathVariable Integer id){
        ApiResponse delet = productService.delet(id);
        return ResponseEntity.status(delet.isSuccess()?201:409).body(delet);
    }

}
