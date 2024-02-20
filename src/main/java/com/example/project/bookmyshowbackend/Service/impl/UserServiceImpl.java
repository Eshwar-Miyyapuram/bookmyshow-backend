package com.example.project.bookmyshowbackend.Service.impl;

import com.example.project.bookmyshowbackend.Adapter.UserAdapter;
import com.example.project.bookmyshowbackend.Dto.UserDto;
import com.example.project.bookmyshowbackend.Models.UserEntity;
import com.example.project.bookmyshowbackend.Repository.UserRepository;
import com.example.project.bookmyshowbackend.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserDto userdto) {

        UserEntity userEntity= UserAdapter.convertDtoToEntity(userdto);

        userRepository.save(userEntity);
    }

    @Override
    public UserDto getUser(int id) {

        UserEntity userEntity= userRepository.findById(id).get();

        UserDto user=UserAdapter.convertEntityToDto(userEntity);

        return user;
    }
}
