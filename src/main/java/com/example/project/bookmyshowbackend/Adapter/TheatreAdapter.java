package com.example.project.bookmyshowbackend.Adapter;

import com.example.project.bookmyshowbackend.Dto.ShowDto;
import com.example.project.bookmyshowbackend.Dto.TheatreDto;
import com.example.project.bookmyshowbackend.Models.ShowEntity;
import com.example.project.bookmyshowbackend.Models.TheatreEntity;
import com.example.project.bookmyshowbackend.Service.impl.ShowServiceImpl;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
