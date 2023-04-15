package com.cars.controller;

import com.cars.dto.UserDTO;
import com.cars.service.UserService;
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

    public final UserService userService;

//    @PostMapping("/create")
//    public UserDTO createCustomer (@RequestBody UserDTO userDTO){
//        return userService.createCustomer(userDTO);
//    }

//    @GetMapping("/list")
//    public ResponseEntity<List<UserDTO>> getListCustomer (){
//        return userService.listCustomer();
//    }





}

