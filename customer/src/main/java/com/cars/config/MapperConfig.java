package com.cars.config;

import com.cars.mapper.CustomerMapper;
import com.cars.mapper.CustomerMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public CustomerMapper customerMapper(){
     return new CustomerMapperImpl();
    }

}
