package com.example.project.bookmyshowbackend.Adapter;

import com.example.project.bookmyshowbackend.Dto.MovieDto;
import com.example.project.bookmyshowbackend.Dto.ShowDto;
import com.example.project.bookmyshowbackend.Models.MovieEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class MovieAdapter {

    public MovieEntity converterDtoToEntity(MovieDto movieDto){
        return MovieEntity.builder().name(movieDto.getName()).releaseDate(movieDto.getReleaseDate()).build();
    }

    public MovieDto converterEntityToDto(MovieEntity movieEntity){
        List<ShowDto> shows=new ArrayList<>();

        return MovieDto.builder().id(movieEntity.getId()).name(movieEntity.getName()).releaseDate(movieEntity.getReleaseDate()).build();
    }
}
