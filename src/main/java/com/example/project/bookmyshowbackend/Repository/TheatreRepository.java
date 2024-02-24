package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.MovieEntity;
import com.example.project.bookmyshowbackend.Models.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheatreRepository extends JpaRepository<TheatreEntity,Integer> {
    List<TheatreEntity> findByName(String name);
}
