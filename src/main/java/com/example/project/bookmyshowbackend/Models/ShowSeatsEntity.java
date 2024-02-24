package com.example.project.bookmyshowbackend.Models;

import com.example.project.bookmyshowbackend.Enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="show_seats")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ShowSeatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String seatNo;

    @Column(nullable = false)
    private int rate;

//    , columnDefinition = "boolean default false"
    @Column(name = "is_booked", columnDefinition = "boolean default false")
    private boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    private Date bookedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatType seatType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private TicketEntity ticket;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private ShowEntity show;

}
