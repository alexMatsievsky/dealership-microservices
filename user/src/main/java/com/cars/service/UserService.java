package com.cars.service;

import com.cars.dto.Role;
import com.cars.dto.UserDTO;
import com.cars.exception.ConflictException;
import com.cars.mapper.UserMapper;
import com.cars.repository.UserRepository;
import com.cars.repository.entity.RoleEntity;
import com.cars.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserEntity createCustomer(UserDTO userDTO) {

        UserEntity savedCustomer;
        try {
            UserEntity userEntity = userMapper.dtoToModel(userDTO);
            userEntity.setRole(new RoleEntity(Role.CUSTOMER.getNumber(), Role.CUSTOMER.getRole()));
            savedCustomer = userRepository.save(userEntity);
        } catch (DataIntegrityViolationException exception){
            log.warn(String.format("can't persist customer with email [%s]", userDTO.getEmail()));
            throw new ConflictException(String.format(
                                "can't persist customer with email [%s]", userDTO.getEmail()));
        }
        return savedCustomer;
    }

    public UserEntity getUserByEmail(String email) {

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ConflictException(String.format(
                        "can't find user by email [%s]", email)));



//        return ResponseEntity.ok(customerRepository.findAll().stream()
//                .map(customerMapper::modelToDto)
//                .collect(Collectors.toList()));

    }
}
