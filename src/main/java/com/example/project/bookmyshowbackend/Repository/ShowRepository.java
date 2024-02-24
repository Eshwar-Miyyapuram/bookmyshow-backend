package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.ShowEntity;
import com.example.project.bookmyshowbackend.Models.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {

    List<ShowEntity> findByTheatre(TheatreEntity theatre);
}
