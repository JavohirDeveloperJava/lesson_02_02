package com.example.lesson_02_02.payload;

import com.example.lesson_02_02.entity.Customer;
import lombok.Data;

@Data
public class PaymentCustomerDto {
    private Integer customerId;
    private Integer productId;
    private String date;
    private double price;

}
