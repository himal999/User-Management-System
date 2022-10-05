package com.asia.usermanagementsystem.service;/*
author :Himal
version : 0.0.1
*/

import com.asia.usermanagementsystem.entity.User;
import com.asia.usermanagementsystem.model.UserDTO;
import com.asia.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

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

    @Override
    public List<UserDTO> allUser() {
        List<User> allUsers = userRepository.findAll();
        List<UserDTO> allUsersDTO = allUsers.stream().map(user -> new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        )).collect(Collectors.toList());
        return allUsersDTO;
    }

    @Override
    public UserDTO updateUser(Long id,UserDTO userDTO) {

        User isUser = userRepository.findById(id).get();
        isUser.setFirstName(userDTO.getFirstName());
        isUser.setLastName(userDTO.getLastName());
        isUser.setEmail(userDTO.getEmail());
        userRepository.save(isUser);
        return userDTO;
    }

    @Override
    public UserDTO findUser(Long id) {
        User user = userRepository.findById(id).get();
        UserDTO userDto = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );

        return userDto;
    }
}
