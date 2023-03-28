package com.cars.config;

import com.cars.mapper.UserMapper;
import com.cars.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public UserMapper customerMapper(){
     return new UserMapperImpl();
    }

}
