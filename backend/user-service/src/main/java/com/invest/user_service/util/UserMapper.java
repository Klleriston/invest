package com.invest.user_service.util;

import com.invest.user_service.DTO.UserDTO;
import com.invest.user_service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromDto(UserDTO dto, @MappingTarget User user);

    User toEntity(UserDTO dto);
}
