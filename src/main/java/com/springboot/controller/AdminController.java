package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String getAllUser(Model model){
        model.addAttribute("getAllUser", this.userService.getAllUser());
        return "getAlluser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddPageUser(Model model){
        model.addAttribute("user", new User());
        return "adduser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deteteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @RequestMapping("/update/{id}")
    public String updatePageUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("addAllUser", userService.getAllUser());
        return "updateUser";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/admin";
    }


}
