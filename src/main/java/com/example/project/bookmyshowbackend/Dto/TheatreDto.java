package com.example.project.bookmyshowbackend.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreDto {

    int id;

    @NotNull
    String name;

    @NotNull
    String address;

    @NotNull
    String city;


    ShowDto showDto;


}


