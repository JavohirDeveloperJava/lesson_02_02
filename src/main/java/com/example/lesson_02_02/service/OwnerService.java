package com.example.lesson_02_02.service;

import com.example.lesson_02_02.entity.Owner;
import com.example.lesson_02_02.entity.Role;
import com.example.lesson_02_02.payload.OwnerDto;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.repository.OwnerRepository;
import com.example.lesson_02_02.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    RoleRepository repository;

    public ApiResponse add(OwnerDto dto){
        Optional<Role> optionalRole = repository.findById(dto.getRoleId());
        if (!optionalRole.isPresent()){
            return new ApiResponse("Bunday role mavjut emas",false);
        }
        Owner owner=new Owner();
        owner.setFirstName(dto.getFirstName());
        owner.setLastName(dto.getLastName());
        owner.setPhoneNumber(dto.getPhoneNumber());
        owner.setRoleId(optionalRole.get());
        ownerRepository.save(owner);
        return new ApiResponse("Owner saqlandi",true);
    }

    public List<Owner> get(){
        return ownerRepository.findAll();
    }


    public ApiResponse put(Integer id,OwnerDto dto){
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (!optionalOwner.isPresent()){
            return new ApiResponse("Bunday owner yoq",false);
        }
        Optional<Role> optionalRole = repository.findById(dto.getRoleId());
        if (!optionalRole.isPresent()){
            return new ApiResponse("Bunday role yoq",false);
        }
        Owner owner = optionalOwner.get();
        owner.setLastName(dto.getLastName());
        owner.setFirstName(dto.getFirstName());
        owner.setRoleId(optionalRole.get());
        ownerRepository.save(owner);
        return new ApiResponse("owner ozgard",true);
    }

    public ApiResponse delet(Integer id){
        try {
            ownerRepository.deleteById(id);
            return new ApiResponse("Owner ochirildi",true);
        }catch (Exception e){
            return new ApiResponse("Hatolik ochmadi",false);
        }
    }

}
