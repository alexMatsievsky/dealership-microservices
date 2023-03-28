package com.cars.controller;

import com.cars.dto.UserDTO;
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
public class UserController {

    public final CustomerService customerService;

    @PostMapping("/create")
    public UserDTO createCustomer (@RequestBody UserRegistrationRequest userRegistrationRequest){
        return customerService.createCustomer(userRegistrationRequest);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> getListCustomer (){
        return customerService.listCustomer();
    }





}

