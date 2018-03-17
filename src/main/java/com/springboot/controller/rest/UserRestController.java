package com.springboot.controller.rest;

import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public ResponseEntity getAllUser(Model model){
        model.addAttribute("getAllUser", this.userService.getAllUser());
        return new ResponseEntity<>(userService.getAllUser(),  HttpStatus.OK);
    }
}
