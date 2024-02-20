package com.example.project.bookmyshowbackend.Models;


import com.example.project.bookmyshowbackend.Enums.SeatType;
import com.example.project.bookmyshowbackend.Enums.TheatreType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import javax.print.DocFlavor;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="theatres")
@Builder
@ToString
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private TheatreType theatreType;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> listOfShows;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheatreSeatEntity> listOfTheatreSeats;

}
