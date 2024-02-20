package com.example.project.bookmyshowbackend.Adapter;

import com.example.project.bookmyshowbackend.Dto.BookTicketRequestDto;
import com.example.project.bookmyshowbackend.Dto.ShowDto;
import com.example.project.bookmyshowbackend.Dto.TicketDto;
import com.example.project.bookmyshowbackend.Dto.UserDto;
import com.example.project.bookmyshowbackend.Models.ShowEntity;
import com.example.project.bookmyshowbackend.Models.TicketEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketAdapter {

    public TicketDto converterEntityToDto(TicketEntity ticketEntity){
        UserDto currUserDto = UserAdapter.convertEntityToDto(ticketEntity.getUser());
        ShowDto currShowDto =ShowAdapter.convertEntityToDto(ticketEntity.getShow());
        return TicketDto.builder().id(ticketEntity.getId()).alloted_seats(ticketEntity.getAllottedSeats()).amount(ticketEntity.getAmount()).userDto(currUserDto).showDto(currShowDto).build();
    }
    public TicketEntity converterDtoToEntity(TicketDto ticketDto){

        return TicketEntity.builder().build();
    }
}
