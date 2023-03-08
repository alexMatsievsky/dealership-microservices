package com.cars.repository.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerEntity {

    Integer id;
    String email;
    String firstName;
    String lastName;
    String password;
}
