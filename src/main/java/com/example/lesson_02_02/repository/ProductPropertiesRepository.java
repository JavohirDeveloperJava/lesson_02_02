package com.example.lesson_02_02.repository;

import com.example.lesson_02_02.entity.ProductProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPropertiesRepository extends JpaRepository<ProductProperties,Integer> {
}
