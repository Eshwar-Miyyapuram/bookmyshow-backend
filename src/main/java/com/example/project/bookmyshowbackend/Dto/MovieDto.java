package com.example.project.bookmyshowbackend.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {

    int id;

    @NotNull
    String name;

    @NotNull
    String releaseDate;

    List<ShowDto> shows;

}
