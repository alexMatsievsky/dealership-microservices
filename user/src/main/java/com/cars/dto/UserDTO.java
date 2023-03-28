package com.cars.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class UserDTO {

    private UUID id;
    private String email;
    private String firstName;
    private String lastName;

}
