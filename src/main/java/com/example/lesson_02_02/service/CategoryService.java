package com.example.lesson_02_02.service;

import com.example.lesson_02_02.entity.Category;
import com.example.lesson_02_02.entity.Owner;
import com.example.lesson_02_02.payload.CategoryDto;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse add(CategoryDto dto){
        Category category=new Category();
        category.setName(dto.getName());
        if (dto.getParentCategory()!=null){
            Optional<Category> optionalCategory = categoryRepository.findById(dto.getParentCategory());
            if (!optionalCategory.isPresent()){
                return new ApiResponse("Bunday ota category mavjut emas",false);
            }
            category.setParentCategory(optionalCategory.get());
        }
        categoryRepository.save(category);
        return new ApiResponse("Muofaqiyatlik saqlandi",true);

    }

    public List<Category> get(){
        return categoryRepository.findAll();
    }

    public ApiResponse put(Integer id,CategoryDto dto){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()){
            return new ApiResponse("Bunday category yoq",false);
        }
        Category category = optionalCategory.get();
        category.setName(dto.getName());
        if (dto.getParentCategory()!=null){
            Optional<Category> optionalCategory1 = categoryRepository.findById(dto.getParentCategory());
            if (!optionalCategory1.isPresent()){
                return new ApiResponse("bunday ota category mavjut emas",false);
            }
            category.setParentCategory(optionalCategory1.get());
        }
        categoryRepository.save(category);
        return new ApiResponse("Category ozgardi",true);
    }

    public ApiResponse delet(Integer id){
        try {
            categoryRepository.deleteById(id);
            return new ApiResponse("category ochdi",true);
        }catch (Exception e){
            return new ApiResponse("Hatolik ochmadi",false);
        }
    }

}
