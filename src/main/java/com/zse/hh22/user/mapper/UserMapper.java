package com.zse.hh22.user.mapper;

import com.zse.hh22.user.api.UserDTO;
import com.zse.hh22.user.api.UserRegisterDTO;
import com.zse.hh22.user.domain.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity mapRegisterDtoToUserEntity(UserRegisterDTO userRegisterDTO);
    UserDTO mapEntityToDto(UserEntity userEntity);
}
