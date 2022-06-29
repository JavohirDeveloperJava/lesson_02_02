package com.example.lesson_02_02.repository;

import com.example.lesson_02_02.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
