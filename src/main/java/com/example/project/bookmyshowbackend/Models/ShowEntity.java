package com.example.project.bookmyshowbackend.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="shows")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)//DATE VARIABLE
    private LocalDate showDate;

    @Column(nullable = false)
    private LocalTime showTime;

    @CreationTimestamp
    @Column(name ="created_at")  // TEMPORAL VALUE
    private Date createdOn;

    @UpdateTimestamp
    @Column(name ="updated_at")
    private Date updatedOn;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private MovieEntity movie;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private TheatreEntity theatre;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TicketEntity> listOfTickets;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> listOfShowSeats;







}
