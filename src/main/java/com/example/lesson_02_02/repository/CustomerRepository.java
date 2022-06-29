package com.example.lesson_02_02.repository;

import com.example.lesson_02_02.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
