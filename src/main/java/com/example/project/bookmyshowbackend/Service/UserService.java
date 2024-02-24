package com.example.project.bookmyshowbackend.Service;

import com.example.project.bookmyshowbackend.Dto.UserDto;

public interface UserService {

    void addUser(UserDto userdto) throws Exception;

    UserDto getUser(int id);
}
