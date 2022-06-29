package com.example.lesson_02_02.controller;

import com.example.lesson_02_02.entity.Product;
import com.example.lesson_02_02.entity.ProductProperties;
import com.example.lesson_02_02.payload.ProductDto;
import com.example.lesson_02_02.payload.ProductPropertiesDto;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.service.ProductPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proper")
public class ProductPropertiesController {
    @Autowired
    ProductPropertiesService productPropertiesService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody ProductPropertiesDto dto){
        ApiResponse add = productPropertiesService.add(dto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }

    @GetMapping
    public HttpEntity<List<ProductProperties>> get(){
        List<ProductProperties> products = productPropertiesService.get();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> put(@PathVariable Integer id, @RequestBody ProductPropertiesDto dto){
        ApiResponse put = productPropertiesService.put(id, dto);
        return ResponseEntity.status(put.isSuccess()?201:409).body(put);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delet(@PathVariable Integer id){
        ApiResponse delet = productPropertiesService.delet(id);
        return ResponseEntity.status(delet.isSuccess()?201:409).body(delet);
    }
}
