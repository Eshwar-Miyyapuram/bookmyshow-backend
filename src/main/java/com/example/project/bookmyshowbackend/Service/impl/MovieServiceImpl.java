package com.example.project.bookmyshowbackend.Service.impl;

import com.example.project.bookmyshowbackend.Adapter.MovieAdapter;
import com.example.project.bookmyshowbackend.Dto.MovieDto;
import com.example.project.bookmyshowbackend.Models.MovieEntity;
import com.example.project.bookmyshowbackend.Models.UserEntity;
import com.example.project.bookmyshowbackend.Repository.MovieRepository;
import com.example.project.bookmyshowbackend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void addMovie(MovieDto movieDto) {

        MovieEntity movieEntity=MovieAdapter.converterDtoToEntity(movieDto);
        movieRepository.save(movieEntity);
    }

    @Override
    public MovieDto getMovie(int id) {
        MovieEntity movieEntity=movieRepository.findById(id).get();
        MovieDto movieDto=MovieAdapter.converterEntityToDto(movieEntity);
        return movieDto;
    }
}
