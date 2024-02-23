package com.example.project.bookmyshowbackend.Service.impl;

import com.example.project.bookmyshowbackend.Adapter.TicketAdapter;
import com.example.project.bookmyshowbackend.Dto.BookTicketRequestDto;
import com.example.project.bookmyshowbackend.Dto.TicketDto;
import com.example.project.bookmyshowbackend.Models.ShowEntity;
import com.example.project.bookmyshowbackend.Models.ShowSeatsEntity;
import com.example.project.bookmyshowbackend.Models.TicketEntity;
import com.example.project.bookmyshowbackend.Models.UserEntity;
import com.example.project.bookmyshowbackend.Repository.ShowRepository;
import com.example.project.bookmyshowbackend.Repository.TicketRepository;
import com.example.project.bookmyshowbackend.Repository.UserRepository;
import com.example.project.bookmyshowbackend.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {

        UserEntity userEntity=userRepository.findById(bookTicketRequestDto.getUserId()).get();

        ShowEntity showEntity =showRepository.findById(bookTicketRequestDto.getShowId()).get();

        Set<String> requestedSeats=bookTicketRequestDto.getRequestedSeats();

        List<ShowSeatsEntity> showSeatsEntityList =showEntity.getListOfShowSeats();

        List<ShowSeatsEntity> bookedSeats = showSeatsEntityList
                .stream()
                .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType()) && !seat.isBooked() && requestedSeats.contains(seat.getSeatNo()))
                .collect(Collectors.toList());

        if(requestedSeats.size()!=bookedSeats.size()) {
            throw new Error("All seats are booked");
        }


        TicketEntity ticketEntity= TicketEntity.builder()
                .show(showEntity).user(userEntity).listOfShowSeats(bookedSeats).build();

        int amount=0;

        for(ShowSeatsEntity seat : bookedSeats) {
            seat.setBooked(true);
            seat.setTicket(ticketEntity);
            seat.setBookedAt(new Date());
            amount += seat.getRate();
        }

        ticketEntity.setAllottedSeats(String.valueOf(bookedSeats));
        ticketEntity.setAmount(amount);

        //Connect in show and USer
//        showEntity.setListOfTickets();
          showEntity.getListOfTickets().add(ticketEntity);
//        userEntity.setListOftTickets();
          userEntity.getListOfTickets().add(ticketEntity);

        ticketRepository.save(ticketEntity);
        return TicketAdapter.converterEntityToDto(ticketEntity);
    }

    @Override
    public TicketDto getTicket(int id) {
        TicketEntity ticketEntity=ticketRepository.findById(id).get();

        return TicketAdapter.converterEntityToDto(ticketEntity);
    }
}
