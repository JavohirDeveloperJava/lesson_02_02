package com.example.lesson_02_02.projection;

import com.example.lesson_02_02.entity.Owner;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Owner.class)
public interface OwnerCustom {

    Integer getId();

    String getFirstName();

    String getLastName();

    String getPhoneNumber();

    Integer getRoleId();

    boolean getActive();



}
