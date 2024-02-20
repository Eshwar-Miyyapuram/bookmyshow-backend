package com.example.project.bookmyshowbackend.Dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {

    int id;
    String alloted_seats;
    int amount;
    ShowDto showDto;
    UserDto userDto;


}
