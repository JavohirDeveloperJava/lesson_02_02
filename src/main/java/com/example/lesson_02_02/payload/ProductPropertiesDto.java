package com.example.lesson_02_02.payload;

import lombok.Data;

@Data
public class ProductPropertiesDto {
    private Integer key;
    private String value;
    private Integer productId;
}
