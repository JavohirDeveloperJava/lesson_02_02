package com.example.lesson_02_02.service;

import com.example.lesson_02_02.entity.Product;
import com.example.lesson_02_02.entity.ProductProperties;
import com.example.lesson_02_02.payload.ProductPropertiesDto;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.repository.ProductPropertiesRepository;
import com.example.lesson_02_02.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductPropertiesService {
    @Autowired
    ProductPropertiesRepository productPropertiesRepository;
    @Autowired
    ProductRepository productRepository;

    public ApiResponse add(ProductPropertiesDto dto){
        Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
        if (!optionalProduct.isPresent()){
            return new ApiResponse("Bunday product mavjut emas",false);
        }
        ProductProperties productProperties=new ProductProperties();
        productProperties.setKey(dto.getKey());
        productProperties.setValue(dto.getValue());
        productProperties.setProductId(optionalProduct.get());
        productPropertiesRepository.save(productProperties);
        return new ApiResponse("saqlandi",true);
    }

    public List<ProductProperties> get(){
        return productPropertiesRepository.findAll();
    }

    public ApiResponse put(Integer id, ProductPropertiesDto dto){
        Optional<ProductProperties> optionalProductProperties = productPropertiesRepository.findById(id);
        if (!optionalProductProperties.isPresent()){
            return new ApiResponse("Bunday properties yoq",false);
        }
        Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
        if (!optionalProduct.isPresent()){
            return new ApiResponse("Bunday product mavjut emas",false);
        }
        ProductProperties productProperties = optionalProductProperties.get();
        productProperties.setKey(dto.getKey());
        productProperties.setValue(dto.getValue());
        productProperties.setProductId(optionalProduct.get());
        productPropertiesRepository.save(productProperties);
        return new ApiResponse("saqlandi",true);

    }

    public ApiResponse delet(Integer id){
        try {
            productPropertiesRepository.deleteById(id);
            return new ApiResponse("ochirildi",true);
        }catch (Exception e){
            return new ApiResponse("hatolik ",false);
        }
    }
}
