package com.example.lesson_02_02.controller;

import com.example.lesson_02_02.entity.Customer;
import com.example.lesson_02_02.entity.PaymentCustomer;
import com.example.lesson_02_02.payload.CustomerDto;
import com.example.lesson_02_02.payload.PaymentCustomerDto;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.service.PaymentCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentCustomerController {
    @Autowired
    PaymentCustomerService paymentCustomerService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody PaymentCustomerDto dto){
        ApiResponse add = paymentCustomerService.add(dto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }

    @GetMapping
    public HttpEntity<List<PaymentCustomer>> get(){
        List<PaymentCustomer> paymentCustomers = paymentCustomerService.get();
        return ResponseEntity.ok(paymentCustomers);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> put(@PathVariable Integer id, @RequestBody PaymentCustomerDto dto){
        ApiResponse put = paymentCustomerService.put(id, dto);
        return ResponseEntity.status(put.isSuccess()?201:409).body(put);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delet(@PathVariable Integer id){
        ApiResponse delet = paymentCustomerService.delet(id);
        return ResponseEntity.status(delet.isSuccess()?201:409).body(delet);
    }
}
