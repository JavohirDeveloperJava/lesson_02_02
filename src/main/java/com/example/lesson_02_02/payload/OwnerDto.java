package com.example.lesson_02_02.payload;

import lombok.Data;

@Data
public class OwnerDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer roleId;


}
