package com.cars.mapper;

import com.cars.dto.UserDTO;
import com.cars.repository.entity.UserEntity;
import com.cars.security.UserSecurity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO modelToDto(UserEntity userEntity);
    UserEntity dtoToModel(UserDTO userDTO);
    @Mapping(target = "role", ignore = true)
    UserSecurity modelToSecurity(UserEntity userEntity);
}