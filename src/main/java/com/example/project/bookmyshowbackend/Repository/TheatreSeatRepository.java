package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.MovieEntity;
import com.example.project.bookmyshowbackend.Models.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheatreSeatRepository extends JpaRepository<TheatreSeatEntity,Integer> {

}
