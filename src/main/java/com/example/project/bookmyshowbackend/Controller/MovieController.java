package com.example.project.bookmyshowbackend.Controller;


import com.example.project.bookmyshowbackend.Dto.MovieDto;
import com.example.project.bookmyshowbackend.Service.MovieService;
import com.example.project.bookmyshowbackend.Service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController{

    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/add")
    public ResponseEntity addMovie(@RequestBody MovieDto movieDto){
        try{
            movieService.addMovie(movieDto);
            return new ResponseEntity<>("Successfully ADDED a movie", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Movie already exists",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity getMovie(@RequestParam int id){
        try{
            MovieDto movie=movieService.getMovie(id);
            return new ResponseEntity(movie,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getMovieById(@PathVariable int id){
        try{
            MovieDto movie=movieService.getMovie(id);
            return new ResponseEntity(movie,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
