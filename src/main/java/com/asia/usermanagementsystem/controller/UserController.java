package com.asia.usermanagementsystem.controller;/*
author :Himal
version : 0.0.1
*/

import com.asia.usermanagementsystem.model.UserDTO;
import com.asia.usermanagementsystem.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {


    private final UserService userService;

    public UserController(UserService userController){
        this.userService = userController;
    }

    @PostMapping("create-User")
    public UserDTO addUser(@RequestBody UserDTO userDTO){

        return userService.addUser(userDTO);
    }
}
