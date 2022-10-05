package com.asia.usermanagementsystem.service;/*
author :Himal
version : 0.0.1
*/

import com.asia.usermanagementsystem.entity.User;
import com.asia.usermanagementsystem.model.UserDTO;
import com.asia.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.UncheckedIOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private User user;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean addUser(UserDTO userDTO) {

        try {
            user = new User();
            BeanUtils.copyProperties(userDTO, user);
            userRepository.save(user);
            return true;
        } catch (UncheckedIOException e) {
            throw new RuntimeException("User Added Failed !!!");
        }


    }

    @Override
    public List<UserDTO> allUser() {

        try {
            List<User> allUsers = userRepository.findAll();
            List<UserDTO> allUsersDTO = allUsers.stream().map(user -> new UserDTO(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail()
            )).collect(Collectors.toList());
            return allUsersDTO;
        } catch (UncheckedIOException e) {
            throw new RuntimeException("Failed to load Users");
        }

    }

    @Override
    public Boolean updateUser(Long id, UserDTO userDTO) {

        if (userRepository.findById(id).isPresent()) {
            user = userRepository.findById(id).get();
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            userRepository.save(user);
            return true;
        } else {
            throw new RuntimeException("Not Present User !!!");
        }


    }

    @Override
    public UserDTO findUser(Long id) {

        if (userRepository.findById(id).isPresent()) {
            user = userRepository.findById(id).get();
            UserDTO userDto = new UserDTO(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail()
            );

            return userDto;
        } else {
            throw new RuntimeException("Not Present User !!!");
        }

    }

    @Override
    public Boolean deleteUser(Long id) {

        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Not Present User !!!");
        }


    }
}
