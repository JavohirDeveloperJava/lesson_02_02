package com.example.lesson_02_02.service;

import com.example.lesson_02_02.entity.Attechment;
import com.example.lesson_02_02.entity.Category;
import com.example.lesson_02_02.entity.Product;
import com.example.lesson_02_02.payload.ProductDto;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.repository.AttechmentRepository;
import com.example.lesson_02_02.repository.CategoryRepository;
import com.example.lesson_02_02.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttechmentRepository attechmentRepository;

    public ApiResponse add(ProductDto dto){
        Optional<Category> optionalCategory = categoryRepository.findById(dto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new ApiResponse("Bunday caegory mavjut emas",false);
        }
        Optional<Attechment> optionalAttechment = attechmentRepository.findById(dto.getAttechmentId());
        if (!optionalAttechment.isPresent()){
            return new ApiResponse("Bunday attechment yoq",false);
        }

        Product product=new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setCategoryId(optionalCategory.get());
        product.setAttechmentId(optionalAttechment.get());
        productRepository.save(product);
        return new ApiResponse("Product saqlandi",true);
    }

    public List<Product> get(){
        return productRepository.findAll();
    }

    public ApiResponse put(Integer id,ProductDto dto){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()){
            return new ApiResponse("Bunday product yoq",false);
        }

        Optional<Category> optionalCategory = categoryRepository.findById(dto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new ApiResponse("Bunday caegory mavjut emas",false);
        }

        Optional<Attechment> optionalAttechment = attechmentRepository.findById(dto.getAttechmentId());
        if (!optionalAttechment.isPresent()){
            return new ApiResponse("Bunday attechment yoq",false);
        }

        Product product = optionalProduct.get();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setCategoryId(optionalCategory.get());
        product.setAttechmentId(optionalAttechment.get());
        productRepository.save(product);
        return new ApiResponse("Product ozgardi",true);
    }

    public ApiResponse delet(Integer id){
        try {
            productRepository.deleteById(id);
            return new ApiResponse("product ochirildi",true);
        }catch (Exception e){
            return new ApiResponse("hatolik ochmadi",false);
        }

    }
}
