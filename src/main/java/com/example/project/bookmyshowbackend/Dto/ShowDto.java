package com.example.project.bookmyshowbackend.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ShowDto {

    int id;
    @NotNull
    LocalDate showDate;
    @NotNull
    LocalTime showTime;
    @NotNull
    MovieDto movieDto;
    @NotNull
    TheatreDto theatreDto;
}
