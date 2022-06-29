package com.example.lesson_02_02.service;

import com.example.lesson_02_02.entity.Customer;
import com.example.lesson_02_02.entity.PaymentCustomer;
import com.example.lesson_02_02.entity.Product;
import com.example.lesson_02_02.payload.PaymentCustomerDto;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.repository.CustomerRepository;
import com.example.lesson_02_02.repository.PaymentCustomerRepository;
import com.example.lesson_02_02.repository.ProductRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentCustomerService {
    @Autowired
    PaymentCustomerRepository paymentCustomerRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

    public ApiResponse add(PaymentCustomerDto dto){
        Optional<Customer> optionalCustomer = customerRepository.findById(dto.getCustomerId());
        if (!optionalCustomer.isPresent()){
            return new ApiResponse("Bunday customer yoq",false);
        }
        Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
        if (!optionalProduct.isPresent()){
            return new ApiResponse("Bunday product yoq",false);
        }

        PaymentCustomer paymentCustomer=new PaymentCustomer();
        paymentCustomer.setPrice(dto.getPrice());
        paymentCustomer.setDate(Date.valueOf(dto.getDate()));
        paymentCustomer.setCustomerId(optionalCustomer.get());
        paymentCustomer.setProductId(optionalProduct.get());
        paymentCustomerRepository.save(paymentCustomer);
        return new ApiResponse("saqlandi",true);
    }

    public List<PaymentCustomer> get(){
        return paymentCustomerRepository.findAll();
    }

    public ApiResponse put(Integer id,PaymentCustomerDto dto){
        Optional<PaymentCustomer> optionalPaymentCustomer = paymentCustomerRepository.findById(id);
        if (!optionalPaymentCustomer.isPresent()){
            return new ApiResponse("Bunday Paymentcustomer yoq",false);
        }
        Optional<Customer> optionalCustomer = customerRepository.findById(dto.getCustomerId());
        if (!optionalCustomer.isPresent()){
            return new ApiResponse("Bunday customer yoq",false);
        }
        Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
        if (!optionalProduct.isPresent()){
            return new ApiResponse("Bunday product yoq",false);
        }

        Customer customer = optionalCustomer.get();
        PaymentCustomer paymentCustomer=new PaymentCustomer();
        paymentCustomer.setPrice(dto.getPrice());
        paymentCustomer.setDate(Date.valueOf(dto.getDate()));
        paymentCustomer.setCustomerId(optionalCustomer.get());
        paymentCustomer.setProductId(optionalProduct.get());
        paymentCustomerRepository.save(paymentCustomer);
        return new ApiResponse("saqlandi",true);
    }

    public ApiResponse delet(Integer id){
        try {
            paymentCustomerRepository.deleteById(id);
            return new ApiResponse("ochirildi",true);
        }catch (Exception e){
            return new ApiResponse("hatolik",false);
        }
    }
}
