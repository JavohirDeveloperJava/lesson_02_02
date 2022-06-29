package com.example.lesson_02_02.payload;

import com.example.lesson_02_02.entity.Attechment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private double price;
    private Integer attechmentId;
    private Integer categoryId;
}
