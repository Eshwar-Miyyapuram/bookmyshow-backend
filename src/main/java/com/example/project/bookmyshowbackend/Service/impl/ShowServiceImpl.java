package com.example.project.bookmyshowbackend.Service.impl;

import com.example.project.bookmyshowbackend.Adapter.ShowAdapter;
import com.example.project.bookmyshowbackend.Dto.ShowDto;
import com.example.project.bookmyshowbackend.Models.*;
import com.example.project.bookmyshowbackend.Repository.*;
import com.example.project.bookmyshowbackend.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowDto addShow(ShowDto showDto) {

        ShowEntity showEntity = ShowAdapter.convertDtoToEntity(showDto);

        MovieEntity movieEntity=movieRepository.findById(showDto.getMovieDto().getId()).get();

        TheatreEntity theatreEntity=theatreRepository.findById(showDto.getTheatreDto().getId()).get();

        showEntity.setMovie(movieEntity);
        showEntity.setTheatre(theatreEntity);

        List<TheatreSeatEntity> list_of_theatreSeats=theatreEntity.getListOfTheatreSeats();

        generateShowSeats(list_of_theatreSeats,showEntity);

        showRepository.save(showEntity);

        return ShowAdapter.convertEntityToDto(showEntity);
    }

    public void generateShowSeats(List<TheatreSeatEntity> list_of_theatreSeats, ShowEntity showEntity){

        List<ShowSeatsEntity> list_of_showSeats=new ArrayList<>();

        for(TheatreSeatEntity seat: list_of_theatreSeats){
            list_of_showSeats.add(ShowSeatsEntity.builder().seatNo(seat.getSeatNo()).rate(seat.getRate()).seatType(seat.getSeatType()).build());
        }

        for(ShowSeatsEntity seat:list_of_showSeats){
            seat.setShow(showEntity);
        }

        showSeatsRepository.saveAll(list_of_showSeats);
    }

    @Override
    public ShowDto getShow(int id) {

        ShowEntity showEntity=showRepository.findById(id).get();
        ShowDto showDto = ShowAdapter.convertEntityToDto(showEntity);
        return showDto;
    }
}
