package com.asia.usermanagementsystem.model;/*
author :Himal
version : 0.0.1
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
