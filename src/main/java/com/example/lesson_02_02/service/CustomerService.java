package com.example.lesson_02_02.service;

import com.example.lesson_02_02.entity.Customer;
import com.example.lesson_02_02.entity.Product;
import com.example.lesson_02_02.payload.CustomerDto;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.repository.CustomerRepository;
import com.example.lesson_02_02.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

    public ApiResponse add(CustomerDto dto){
        Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
        if (!optionalProduct.isPresent()){
            return new ApiResponse("Bunday product mavjut emas",false);
        }
        Customer customer=new Customer();
        customer.setFullName(dto.getFullName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setProductId(optionalProduct.get());
        customerRepository.save(customer);
        return new ApiResponse("customer saqlandi",true);
    }
    public List<Customer> get(){
        return customerRepository.findAll();
    }

    public ApiResponse put(Integer id,CustomerDto dto){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (!optionalCustomer.isPresent()){
            return new ApiResponse("Bunday customer yoq",false);
        }
        Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
        if (!optionalProduct.isPresent()){
            return new ApiResponse("Bunday product mavjut emas",false);
        }
        Customer customer = optionalCustomer.get();
        customer.setFullName(dto.getFullName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setProductId(optionalProduct.get());
        customerRepository.save(customer);
        return new ApiResponse("customer saqlandi",true);
    }

    public ApiResponse delet(Integer id){
        try {
            customerRepository.deleteById(id);
            return new ApiResponse("customer ochdi",true);
        }catch (Exception e){
            return new ApiResponse("hatolik ochmadi",false);
        }
    }

}
