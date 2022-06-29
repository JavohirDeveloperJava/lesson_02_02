package com.example.lesson_02_02.repository;

import com.example.lesson_02_02.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
