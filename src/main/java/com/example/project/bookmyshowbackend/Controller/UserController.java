package com.example.project.bookmyshowbackend.Controller;


import com.example.project.bookmyshowbackend.Dto.UserDto;
import com.example.project.bookmyshowbackend.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserDto userDto){
        try{
            userService.addUser(userDto);
            return new ResponseEntity<>("Added successfully the user",HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>("User parameters are missing. User not added", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity getUserDetails(@RequestParam int id){
        try{
            UserDto user=userService.getUser(id);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>("User doesn't exists", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get_user/{id}")
    public ResponseEntity getUserDetailsByPath(@PathVariable("id")int id){
        try{
            UserDto user=userService.getUser(id);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>("User doesn't exists", HttpStatus.NOT_FOUND);
        }
    }

}
