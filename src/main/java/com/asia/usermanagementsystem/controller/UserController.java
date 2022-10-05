package com.asia.usermanagementsystem.controller;/*
author :Himal
version : 0.0.1
*/

import com.asia.usermanagementsystem.model.UserDTO;
import com.asia.usermanagementsystem.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    //add user hadler method
    @PostMapping("/create-user")
    public UserDTO addUser(@RequestBody UserDTO userDTO){

        return userService.addUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> allUser(){
        return userService.allUser();
    }

    @PutMapping(path = "/{id}")
    public UserDTO updateUser(@PathVariable("id") Long id,@ModelAttribute UserDTO userDTO){
        return userService.updateUser(id,userDTO);
    }
}
