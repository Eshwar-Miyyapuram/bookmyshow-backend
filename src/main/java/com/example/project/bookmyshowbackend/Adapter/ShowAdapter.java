package com.example.project.bookmyshowbackend.Adapter;

import com.example.project.bookmyshowbackend.Dto.ShowDto;
import com.example.project.bookmyshowbackend.Models.ShowEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowAdapter {

    public ShowDto convertEntityToDto(ShowEntity showEntity){
        return ShowDto.builder().id(showEntity.getId()).showDate(showEntity.getShowDate()).showTime(showEntity.getShowTime())
                .build();
    }

    public ShowEntity convertDtoToEntity(ShowDto showDto){
        return ShowEntity.builder().showDate(showDto.getShowDate()).showTime(showDto.getShowTime()).build();
    }
}
