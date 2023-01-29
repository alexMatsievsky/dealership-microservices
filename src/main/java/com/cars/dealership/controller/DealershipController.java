package com.cars.dealership.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealershipController {

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
}
