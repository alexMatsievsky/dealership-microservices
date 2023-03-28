package com.cars.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRegistrationRequest {

    public String email;
    public String firstName;
    public String lastName;
    public String password;

}
