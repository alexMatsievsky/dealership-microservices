package com.cars.service;

import com.cars.controller.UserRegistrationRequest;
import com.cars.dto.UserDTO;
import com.cars.exception.ConflictException;
import com.cars.mapper.UserMapper;
import com.cars.repository.UserRepository;
import com.cars.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CustomerService {

    private final UserRepository userRepository;

    private final UserMapper customerMapper;

    public UserDTO createCustomer(UserRegistrationRequest request) {

        UserEntity userEntity =
                UserEntity.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .build();


        UserEntity savedCustomer = null;
        try {
            savedCustomer = userRepository.save(userEntity);
        } catch (DataIntegrityViolationException exception){
            throw new ConflictException(String.format(
                                "can't persist customer with email [%s]", request.getEmail()));
        }
        return customerMapper.modelToDto(savedCustomer);

    }

    public ResponseEntity<List<UserDTO>> listCustomer() {


        List<UserDTO> fgfdg = Optional.of(userRepository.findAll()
                        .stream()
                        .map(customerMapper::modelToDto)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> {
                    throw new ConflictException("fgfdg");
                });

        return ResponseEntity.ok(fgfdg);


//        return ResponseEntity.ok(customerRepository.findAll().stream()
//                .map(customerMapper::modelToDto)
//                .collect(Collectors.toList()));

    }
}
