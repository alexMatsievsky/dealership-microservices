package com.cars.service;

import com.cars.controller.data.AuthenticationRequest;
import com.cars.controller.data.AuthenticationResponse;
import com.cars.controller.data.RegisterRequest;
import com.cars.dto.UserDTO;
import com.cars.mapper.UserMapper;
import com.cars.repository.UserRepository;
import com.cars.repository.entity.UserEntity;
import com.cars.security.JwtService;
import com.cars.security.UserSecurity;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserService userService;

    private final JwtService jwtService;

    private final UserMapper userMapper;

    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(UserDTO userDTO) {
        UserEntity customer = userService.createCustomer(userDTO);
        String token = jwtService.generateToken(userMapper.modelToSecurity(customer));
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

        UserSecurity userSecurity = userMapper.modelToSecurity(userService.getUserByEmail(request.getEmail()));
        String jwtToken = jwtService.generateToken(userSecurity);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
