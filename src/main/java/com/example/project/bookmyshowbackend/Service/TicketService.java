package com.example.project.bookmyshowbackend.Service;

import com.example.project.bookmyshowbackend.Dto.BookTicketRequestDto;
import com.example.project.bookmyshowbackend.Dto.TicketDto;

public interface TicketService {

    TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

   TicketDto getTicket(int id);
}
