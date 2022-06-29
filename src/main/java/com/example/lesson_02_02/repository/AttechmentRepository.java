package com.example.lesson_02_02.repository;

import com.example.lesson_02_02.entity.Attechment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttechmentRepository extends JpaRepository<Attechment,Integer> {
}
