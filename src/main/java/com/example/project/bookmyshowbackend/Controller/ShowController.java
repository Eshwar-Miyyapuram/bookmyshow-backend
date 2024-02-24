package com.example.project.bookmyshowbackend.Controller;

import com.example.project.bookmyshowbackend.Dto.ShowDto;
import com.example.project.bookmyshowbackend.Service.impl.ShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowServiceImpl showService;

    @PostMapping("/add")
    public ResponseEntity addShow(@RequestBody ShowDto showDto){
        try{
            ShowDto show = showService.addShow(showDto);
            return new ResponseEntity<>(show,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Adding show FAILED!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity getShowDetails(@RequestParam int id){
        try{
            ShowDto show = showService.getShow(id);
            return new ResponseEntity<>(show,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("FAILED!", HttpStatus.BAD_REQUEST);
        }
    }





















}
