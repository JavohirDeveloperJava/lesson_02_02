package com.example.lesson_02_02.repository;

import com.example.lesson_02_02.entity.Role;
import com.example.lesson_02_02.projection.RoleCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "role",excerptProjection = RoleCustom.class)
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
