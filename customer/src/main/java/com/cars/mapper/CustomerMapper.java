package com.cars.mapper;

import com.cars.dto.CustomerDTO;
import com.cars.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO modelToDto(CustomerEntity customerEntity);
}