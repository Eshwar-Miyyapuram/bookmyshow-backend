package com.example.project.bookmyshowbackend.Adapter;


import com.example.project.bookmyshowbackend.Dto.UserDto;
import com.example.project.bookmyshowbackend.Models.UserEntity;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class UserAdapter {

    public UserEntity convertDtoToEntity(UserDto userDto){
        return UserEntity.builder().name(userDto.getName()).mobileNo(userDto.getMobileNo()).build();
    }

    public UserDto convertEntityToDto(UserEntity userEntity){
        return UserDto.builder().id(userEntity.getId()).name(userEntity.getName()).mobileNo(userEntity.getMobileNo()).build();
    }
}
