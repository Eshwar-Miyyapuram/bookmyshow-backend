package com.example.project.bookmyshowbackend.Service;

import com.example.project.bookmyshowbackend.Dto.ShowDto;

public interface ShowService {

    ShowDto addShow(ShowDto showDto);
    ShowDto getShow(int id);
}
