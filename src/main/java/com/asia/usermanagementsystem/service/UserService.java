package com.asia.usermanagementsystem.service;/*
author :Himal
version : 0.0.1
*/

import com.asia.usermanagementsystem.model.UserDTO;

import java.util.List;


public interface UserService {
    UserDTO addUser(UserDTO userDTO);
    List<UserDTO> allUser();
    UserDTO updateUser(Long id,UserDTO userDTO);
    UserDTO findUser (Long id);
}
