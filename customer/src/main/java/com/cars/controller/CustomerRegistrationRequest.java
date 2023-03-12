package com.cars.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.jdbc.core.SqlReturnType;

@Data
@Builder
@AllArgsConstructor
public class CustomerRegistrationRequest {

    public String email;
    public String firstName;
    public String lastName;
    public String password;

}
