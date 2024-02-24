package com.example.project.bookmyshowbackend.Service;

import com.example.project.bookmyshowbackend.Dto.MovieDto;

public interface MovieService {

//    ?createTableIfNotExists=true
    void addMovie(MovieDto movieDto) throws Exception;

    MovieDto getMovie(int id);
}
