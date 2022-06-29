package com.example.lesson_02_02.repository;

import com.example.lesson_02_02.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OwnerRepository extends JpaRepository<Owner,Integer> {
}
