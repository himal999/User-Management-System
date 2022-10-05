package com.asia.usermanagementsystem.controller;/*
author :Himal
version : 0.0.1
*/

import com.asia.usermanagementsystem.model.UserDTO;
import com.asia.usermanagementsystem.service.UserService;
import com.asia.usermanagementsystem.util.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //add new user
    @PostMapping("/create-user")
    public Response addUser(@RequestBody UserDTO userDTO) {
        return new Response(200, userService.addUser(userDTO), "ok");
    }

    //get all users
    @GetMapping
    public Response allUser() {
        return new Response(200, userService.allUser(), "ok");
    }

    //update user details
    @PutMapping(path = "/{id}")
    public Response updateUser(@PathVariable("id") Long id, @ModelAttribute UserDTO userDTO) {
        return new Response(200, userService.updateUser(id, userDTO), "ok");
    }

    //find single user
    @GetMapping("/find")
    public Response findUser(@RequestParam("id") Long id) {
        return new Response(200, userService.findUser(id), "ok");
    }

    @DeleteMapping
    public Response removeUser(@RequestParam("id") Long id) {
        return new Response(200, userService.deleteUser(id), "ok");
    }
}
