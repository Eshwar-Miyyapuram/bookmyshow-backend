package com.example.project.bookmyshowbackend.Dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ShowDto {

    int id;
    LocalDate showDate;
    LocalDate showTime;
    MovieDto movieDto;
    TheatreDto theatreDto;
}
