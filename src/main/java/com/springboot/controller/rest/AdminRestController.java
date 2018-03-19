package com.springboot.controller.rest;

import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class AdminRestController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/admin")
    public ResponseEntity getAllUser(){
        return new ResponseEntity <>(userService.getAllUser(), HttpStatus.OK);
    }


    @PostMapping(value = "/admin")
    public ResponseEntity<Void> addUser(@ModelAttribute("AddUser") User user){
        userService.addUser(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/admin/{id}")
    public ResponseEntity<Void> deteteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @PutMapping("/admin/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") int id){
        userService.updateUser(userService.getUserById(id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }



/*
    @PutMapping(value = "/admin{id}")
    public ResponseEntity<Void> updateUser(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("login") String login,
            @RequestParam("password") String password){

        User user = new User(id, name, login, password);
        userService.updateUser(user);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }*/
}
