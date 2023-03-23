package com.cars.service;

import com.cars.controller.CustomerRegistrationRequest;
import com.cars.dto.CustomerDTO;
import com.cars.exception.ConflictException;
import com.cars.mapper.CustomerMapper;
import com.cars.repository.CustomerRepository;
import com.cars.repository.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public CustomerDTO createCustomer(CustomerRegistrationRequest request) {

        CustomerEntity customerEntity =
                CustomerEntity.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .build();


        CustomerEntity savedCustomer = null;
        try {
            savedCustomer = customerRepository.save(customerEntity);
        } catch (DataIntegrityViolationException exception){
            throw new ConflictException(String.format(
                                "can't persist customer with email [%s]", request.getEmail()));
        }
        return customerMapper.modelToDto(savedCustomer);

    }

    public ResponseEntity<List<CustomerDTO>> listCustomer() {


        List<CustomerDTO> fgfdg = Optional.of(customerRepository.findAll()
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
