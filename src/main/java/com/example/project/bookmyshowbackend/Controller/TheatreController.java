package com.example.project.bookmyshowbackend.Controller;


import com.example.project.bookmyshowbackend.Dto.ShowDto;
import com.example.project.bookmyshowbackend.Dto.TheatreDto;
import com.example.project.bookmyshowbackend.Service.impl.TheatreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreServiceImpl theatreService;

    @PostMapping("/add")
    public ResponseEntity addTheatre(@RequestBody TheatreDto theatreDto){
        try{
            TheatreDto theatre=theatreService.addTheatre(theatreDto);
            return new ResponseEntity<>(theatre, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Adding theatre is FAILED",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity getTheatreDetails(@RequestParam int id){
        try{
            TheatreDto theatre = theatreService.getTheatre(id);
            return new ResponseEntity<>(theatre,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("FAILED!", HttpStatus.BAD_REQUEST);
        }
    }
}
