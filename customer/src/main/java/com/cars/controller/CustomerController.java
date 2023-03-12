package com.cars.controller;

import com.cars.repository.CustomerRepository;
import com.cars.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.cars.repository.entity.CustomerEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor

public class CustomerController {
    private final CustomerService orderService;


    private final CustomerRepository customerRepository;
    @PostMapping("/create")
    public void createCustomer (@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        CustomerEntity customerEntity =
                CustomerEntity.builder()
                        .firstNa(customerRegistrationRequest.getFirstName())
                        .lastNa(customerRegistrationRequest.getLastName())
                        .email(customerRegistrationRequest.getEmail())
                        .password(customerRegistrationRequest.password)
                .build();

        customerRepository.save(customerEntity);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerRegistrationRequest>> findAll (){
        List<CustomerEntity> allCustomer = customerRepository.findAll();
        List<CustomerRegistrationRequest> responseAllCustomer =
        allCustomer.stream()
                .map(customerEntity -> {
                    return CustomerRegistrationRequest.builder()
//                            .firstName(customerEntity.getFirstNa())
//                            .lastName(customerEntity.getLastNa())
                            .email(customerEntity.getEmail())
                            .build();
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseAllCustomer);

    }





}

