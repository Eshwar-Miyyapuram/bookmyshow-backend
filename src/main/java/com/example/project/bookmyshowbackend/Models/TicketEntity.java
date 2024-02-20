package com.example.project.bookmyshowbackend.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tickets")
@Builder
@ToString
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String allottedSeats;

    @Column(nullable = false)
    private int amount;

    @CreationTimestamp
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private UserEntity user;


    // showEntity
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ShowEntity show;

    // ShowSeatsEntity
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowSeatsEntity> listOfShowSeats;


}
