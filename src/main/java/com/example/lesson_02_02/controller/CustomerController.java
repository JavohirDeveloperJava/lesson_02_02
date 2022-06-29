package com.example.lesson_02_02.controller;

import com.example.lesson_02_02.entity.Customer;
import com.example.lesson_02_02.entity.Product;
import com.example.lesson_02_02.payload.CustomerDto;
import com.example.lesson_02_02.payload.ProductDto;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody CustomerDto dto){
        ApiResponse add = customerService.add(dto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }

    @GetMapping
    public HttpEntity<List<Customer>> get(){
        List<Customer> customers = customerService.get();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> put(@PathVariable Integer id, @RequestBody CustomerDto dto){
        ApiResponse put = customerService.put(id, dto);
        return ResponseEntity.status(put.isSuccess()?201:409).body(put);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delet(@PathVariable Integer id){
        ApiResponse delet = customerService.delet(id);
        return ResponseEntity.status(delet.isSuccess()?201:409).body(delet);
    }
}
