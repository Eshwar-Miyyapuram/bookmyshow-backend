package com.example.project.bookmyshowbackend.Service;

import com.example.project.bookmyshowbackend.Dto.TheatreDto;

public interface TheatreService {

    TheatreDto addTheatre(TheatreDto theatreDto);

    TheatreDto getTheatre(int id);

}
