package com.cars.controller;

import com.cars.dto.CustomerDTO;
import com.cars.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    public final CustomerService customerService;

    @PostMapping("/create")
    public CustomerDTO createCustomer (@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        return customerService.createCustomer(customerRegistrationRequest);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CustomerDTO>> getListCustomer (){
        return customerService.listCustomer();
    }





}

