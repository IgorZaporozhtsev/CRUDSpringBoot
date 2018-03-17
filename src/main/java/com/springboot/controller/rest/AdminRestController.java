package com.springboot.controller.rest;

import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/admin")
    public ResponseEntity getAllUser(Model model){
        model.addAttribute("getAllUser", userService.getAllUser());
        model.addAttribute("AddUser", new User());
        model.addAttribute("UpdateUser", new User());
        return new ResponseEntity<>(new User(22,"ee", "ee", "ee"),  HttpStatus.OK);
    }

   /* @PostMapping(value = "/admin")
    public String addUser(@ModelAttribute("AddUser") User user){
        userService.addUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping(value = "/admin/{id}")
    public String deteteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("login") String login,
            @RequestParam("password") String password){

        User user = new User(id, name, login, password);
        userService.updateUser(user);

        return "redirect:/admin";
    }*/

}
