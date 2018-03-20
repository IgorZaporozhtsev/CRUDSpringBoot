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
    public ResponseEntity addUser(@ModelAttribute("AddUser") User user){
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/admin/{id}")
    public ResponseEntity deteteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/admin")
    public ResponseEntity updateUser(User user){
        userService.updateUser(user);
        return new ResponseEntity (HttpStatus.OK);
    }

}
