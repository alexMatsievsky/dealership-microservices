package com.cars.mapper;

import com.cars.dto.UserDTO;
import com.cars.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO modelToDto(UserEntity userEntity);
}