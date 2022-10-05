package com.asia.usermanagementsystem.service;/*
author :Himal
version : 0.0.1
*/

import com.asia.usermanagementsystem.entity.User;
import com.asia.usermanagementsystem.model.UserDTO;
import com.asia.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    private  final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        userRepository.save(user);
        return userDTO;
    }
}
