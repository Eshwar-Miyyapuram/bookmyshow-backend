package com.example.project.bookmyshowbackend.Adapter;

import com.example.project.bookmyshowbackend.Dto.TheatreDto;
import com.example.project.bookmyshowbackend.Models.TheatreEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreAdapter {

    public TheatreEntity convertDtoToEntity(TheatreDto theatreDto){
        return TheatreEntity.builder().name(theatreDto.getName()).city(theatreDto.getCity()).address(theatreDto.getAddress())
                .build();
    }

    public TheatreDto convertEntityToDto(TheatreEntity theatreEntity){

        return TheatreDto.builder().id(theatreEntity.getId()).name(theatreEntity.getName()).address(theatreEntity.getAddress())
                .city(theatreEntity.getCity()).build();

    }
}
