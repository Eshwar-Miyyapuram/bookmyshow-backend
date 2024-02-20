package com.example.project.bookmyshowbackend.Service;

import com.example.project.bookmyshowbackend.Dto.MovieDto;

public interface MovieService {

    void addMovie(MovieDto movieDto);

    MovieDto getMovie(int id);
}
