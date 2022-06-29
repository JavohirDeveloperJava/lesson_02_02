package com.example.lesson_02_02.payload;

import lombok.Data;

@Data
public class CustomerDto {
    private String fullName;
    private String phoneNumber;
    private String email;
    private Integer productId;

}
