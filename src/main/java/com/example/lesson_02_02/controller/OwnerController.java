package com.example.lesson_02_02.controller;

import com.example.lesson_02_02.entity.Owner;
import com.example.lesson_02_02.payload.OwnerDto;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody OwnerDto dto){
        ApiResponse add = ownerService.add(dto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }

    @GetMapping
    public HttpEntity<List<Owner>> get(){
        List<Owner> owners = ownerService.get();
        return ResponseEntity.ok(owners);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> put(@PathVariable Integer id, @RequestBody OwnerDto dto){
        ApiResponse put = ownerService.put(id, dto);
        return ResponseEntity.status(put.isSuccess()?201:409).body(put);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delet(@PathVariable Integer id){
        ApiResponse delet = ownerService.delet(id);
        return ResponseEntity.status(delet.isSuccess()?201:409).body(delet);
    }
}
