package com.example.project.bookmyshowbackend.Dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    int id;

    @NotNull
    String name;

    @NotNull
    String mobileNo;
}
