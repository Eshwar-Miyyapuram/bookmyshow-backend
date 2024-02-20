package com.example.project.bookmyshowbackend.Models;

import com.example.project.bookmyshowbackend.Enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="theatre_seats")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TheatreSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String seatNo;

    @Column(nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatType seatType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private TheatreEntity theatre;

}
