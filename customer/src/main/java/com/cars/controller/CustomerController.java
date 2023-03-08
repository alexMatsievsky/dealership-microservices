package com.cars.controller;

import com.cars.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor

public class CustomerController {
    private final CustomerService orderService;

    @PostMapping
    public void createCustomer (@RequestBody CustomerRegistrationRequest customerRegistrationRequest){


    }



}

