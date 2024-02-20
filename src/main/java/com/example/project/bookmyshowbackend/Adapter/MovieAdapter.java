package com.example.project.bookmyshowbackend.Adapter;

import com.example.project.bookmyshowbackend.Dto.MovieDto;
import com.example.project.bookmyshowbackend.Models.MovieEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieAdapter {

    public MovieEntity converterDtoToEntity(MovieDto movieDto){
        return MovieEntity.builder().name(movieDto.getName()).releaseDate(movieDto.getName()).build();
    }

    public MovieDto converterEntityToDto(MovieEntity movieEntity){
        return MovieDto.builder().id(movieEntity.getId()).name(movieEntity.getName()).releaseDate(movieEntity.getName()).build();
    }
}
