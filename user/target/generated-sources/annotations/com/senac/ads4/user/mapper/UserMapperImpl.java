package com.senac.ads4.user.mapper;

import com.senac.ads4.user.dto.UserDto;
import com.senac.ads4.user.model.UserModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-07T10:21:33-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(UserModel entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( entity.getId() );
        userDto.setNome( entity.getNome() );
        userDto.setCpf( entity.getCpf() );
        userDto.setTelefone( entity.getTelefone() );
        userDto.setEmail( entity.getEmail() );

        return userDto;
    }

    @Override
    public UserModel toModel(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( dto.getId() );
        userModel.setNome( dto.getNome() );
        userModel.setCpf( dto.getCpf() );
        userModel.setTelefone( dto.getTelefone() );
        userModel.setEmail( dto.getEmail() );

        return userModel;
    }

    @Override
    public List<UserDto> toDtoList(List<UserModel> entity) {
        if ( entity == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( entity.size() );
        for ( UserModel userModel : entity ) {
            list.add( toDto( userModel ) );
        }

        return list;
    }

    @Override
    public List<UserModel> toModelList(List<UserDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<UserModel> list = new ArrayList<UserModel>( dto.size() );
        for ( UserDto userDto : dto ) {
            list.add( toModel( userDto ) );
        }

        return list;
    }
}
