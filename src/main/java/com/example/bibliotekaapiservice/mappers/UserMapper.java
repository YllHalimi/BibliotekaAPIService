package com.example.bibliotekaapiservice.mappers;

import com.example.bibliotekaapiservice.DTO.UserDTO;
import com.example.bibliotekaapiservice.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
}
