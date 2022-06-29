package com.example.lesson_02_02.projection;

import com.example.lesson_02_02.entity.Role;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Role.class)
public interface RoleCustom {

    Integer getId();

    String getName();
}
