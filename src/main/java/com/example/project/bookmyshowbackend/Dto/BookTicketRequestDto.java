package com.example.project.bookmyshowbackend.Dto;

import com.example.project.bookmyshowbackend.Enums.SeatType;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookTicketRequestDto {

    Set<String> requestedSeats;

    int userId;

    int showId;

    SeatType seatType;
}
