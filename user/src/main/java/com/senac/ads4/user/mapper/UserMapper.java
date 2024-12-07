package com.senac.ads4.user.mapper;

import com.senac.ads4.user.dto.UserDto;
import com.senac.ads4.user.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //Converte entidade para DTO
    UserDto toDto(UserModel entity);

    //Converte DTO para entidade
    UserModel toModel(UserDto dto);

    //Converter a lista de entidades para lista de DTos
    List<UserDto> toDtoList(List<UserModel> entity);

    //Converter lista de DTOs para lista de entidades
    List<UserModel> toModelList(List<UserDto> dto);
}
