package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
}
