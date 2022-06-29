package com.example.lesson_02_02.repository;

import com.example.lesson_02_02.entity.PaymentCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentCustomerRepository extends JpaRepository<PaymentCustomer,Integer> {
}
