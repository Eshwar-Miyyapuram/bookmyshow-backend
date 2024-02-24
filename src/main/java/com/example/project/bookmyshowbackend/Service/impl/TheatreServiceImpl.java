package com.example.project.bookmyshowbackend.Service.impl;

import com.example.project.bookmyshowbackend.Adapter.TheatreAdapter;
import com.example.project.bookmyshowbackend.Dto.TheatreDto;
import com.example.project.bookmyshowbackend.Enums.SeatType;
import com.example.project.bookmyshowbackend.Models.TheatreEntity;
import com.example.project.bookmyshowbackend.Models.TheatreSeatEntity;
import com.example.project.bookmyshowbackend.Repository.MovieRepository;
import com.example.project.bookmyshowbackend.Repository.TheatreRepository;
import com.example.project.bookmyshowbackend.Repository.TheatreSeatRepository;
import com.example.project.bookmyshowbackend.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Override
    public TheatreDto addTheatre(TheatreDto theatreDto) throws Exception {
        List<TheatreEntity> theatreEntityList=theatreRepository.findByName(theatreDto.getName());
        if(theatreEntityList.size()>0){
            throw new Exception();
        }
        TheatreEntity theatreEntity = TheatreAdapter.convertDtoToEntity(theatreDto);
        theatreRepository.save(theatreEntity);
        createTheatreSeats(theatreEntity);
        theatreRepository.save(theatreEntity);
        return theatreDto;
    }

    void createTheatreSeats(TheatreEntity theatreEntity){

        List<TheatreSeatEntity> seats= new ArrayList<>();

        seats.add(getTheatreSeats("A1",100,SeatType.CLASSIC,theatreEntity));
        seats.add(getTheatreSeats("A2",100,SeatType.CLASSIC,theatreEntity));
        seats.add(getTheatreSeats("A3",100,SeatType.CLASSIC,theatreEntity));
        seats.add(getTheatreSeats("A4",100,SeatType.CLASSIC,theatreEntity));
        seats.add(getTheatreSeats("A5",100,SeatType.CLASSIC,theatreEntity));

        seats.add(getTheatreSeats("B1",200,SeatType.PREMIUM,theatreEntity));
        seats.add(getTheatreSeats("B2",200,SeatType.PREMIUM,theatreEntity));
        seats.add(getTheatreSeats("B3",200,SeatType.PREMIUM,theatreEntity));
        seats.add(getTheatreSeats("B4",200,SeatType.PREMIUM,theatreEntity));
        seats.add(getTheatreSeats("B5",200,SeatType.PREMIUM,theatreEntity));

        theatreEntity.setListOfTheatreSeats(seats);
//        theatreSeatRepository.saveAll(seats);
    }

    TheatreSeatEntity getTheatreSeats(String seatName, int rate, SeatType seatType,TheatreEntity theatreEntity) {

        TheatreSeatEntity theatreSeatEntity= TheatreSeatEntity.builder().seatNo(seatName).rate(rate).seatType(seatType).build();
        theatreSeatEntity.setTheatre(theatreEntity);

        theatreSeatRepository.save(theatreSeatEntity);
        return theatreSeatEntity;
    }


    @Override
    public TheatreDto getTheatre(int id) {

        TheatreEntity theatreEntity = theatreRepository.findById(id).get();
        TheatreDto theatreDto = TheatreAdapter.convertEntityToDto(theatreEntity);
        return theatreDto;
    }
}
